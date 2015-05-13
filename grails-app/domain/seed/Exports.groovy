package seed

class Exports {
    String imp_exp;
    String country;
    Integer year;
    Integer month;
    Integer value;
    String unit1;
    Integer qty1;
    String unit2;
    Integer qty2;
    String hts;
    String htsdesc;
    Integer id;

    static mapping = {
        table 'exports'
        version false
        id column:'id'
        columns {
            imp_exp column:'imp_exp'
            country column:'country'
            year column:'year'
            month column:'month'
            value column:'value'
            unit1 column:'unit1'
            qty1 column:'qty1'
            unit2 column:'unit2'
            qty2 column:'qty2'
            hts column:'hts'
            htsdesc column:'htsdesc'
        }
    }

    static constraints = {
    }
}
