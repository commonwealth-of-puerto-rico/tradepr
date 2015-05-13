class UrlMappings {

	static mappings = {

        "/home/loginSuccess" (controller: "loginSuccess")

        "/api/tradepr/toptrading/${year}/${month}" {
            controller =  "topTradingApi"
            action = "topTrading"
            constraints {
                year matches: /[0-9]{4}/
                month matches:  /0[1-9]|1[012]/
            }
        }

        "/api/tradepr/toptrading/partners" {
            controller =  "topTradingApi"
            action = "partners"
        }

        "/api/tradepr/toptrading/" {
            controller =  "topTradingApi"
            action = "index"
        }




        "/login/$action" (controller: "login")
        "/logout/$action" (controller:  "logout")

        "/"(view:"/index")
        "500"(view:'/error')

        "/home/dashboard" (view: "/dashboard")
        "/home/webflow/$action?/$id?(.${format})?" (controller: "webflow")

        "/secure/dashboard" (view: "/dashboard")

        "/secure/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }


	}
}
