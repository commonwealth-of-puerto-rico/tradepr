package seed.api

import seed.Exports
import seed.Imports

class TopTradingApiController {

    def tradePRService

    def index() {}

    def partners(){
        final session = grailsApplication
                .mainContext
                .sessionFactory
                .currentSession

        String query = $/
select distinct year from imports order by year DESC
/$
        def years = session
            .createSQLQuery(query)
                .list()

        [years: years];
    }

    def topTrading(Integer year, Integer month) {

        final session = grailsApplication
                .mainContext
                .sessionFactory
                .currentSession

        String query = $/
select sum(value) from imports where year=:year and month=:month
/$

        def totalImports = session
                .createSQLQuery(query)
                .setLong('year', year)
                .setLong('month', month)
                .list()

        query = $/
select sum(value) from exports where year=:year and month=:month
/$

        def totalExports = session
                .createSQLQuery(query)
                .setLong('year', year)
                .setLong('month', month)
                .list()

        query = $/
select imptable.country, imptable.total as imptotal, exptable.country, exptable.total as exptotal,
       imptable.total+exptable.total as grandtotal from
   (select country, sum(value) as total from exports
    where year=:year and month=:month group by country)  exptable
  left join
(select country, sum(value) as total from imports
    where year=:year and month=:month group by country)  imptable
    on imptable.country=exptable.country
order by grandtotal DESC
 limit 15
/$
        def totalTrade = session
                .createSQLQuery(query)
                .setLong('year', year)
                .setLong('month', month)
                .list()

        query = $/
select country, sum(value) as total from imports where year=:year and month=:month group by country order by total DESC limit 15;
/$

        def topImports = session
                .createSQLQuery(query)
                .setLong('year', year)
                .setLong('month', month)
                .list()

        query = $/
select country, sum(value) as total from exports where year=:year and month=:month group by country order by total DESC limit 15;
/$
        def topExports = session
                .createSQLQuery(query)
                .setLong('year', year)
                .setLong('month', month)
                .list()

        [totalImports: totalImports,
         totalExports: totalExports,
         totalTrade: totalTrade,
         topImports: topImports,
         topExports: topExports
        ]
    }
}

