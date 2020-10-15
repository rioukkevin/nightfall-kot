"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
var body_parser_1 = __importDefault(require("body-parser"));
var express_1 = __importDefault(require("express"));
var passport_config_1 = __importDefault(require("./config/passport.config"));
var connection_1 = require("./database/connection");
var routes_1 = __importDefault(require("./routes"));
//Express application
var app = express_1.default();
//#region Configuration
/**Database connection */
connection_1.connectToDb();
/**Configure authentication */
passport_config_1.default();
//#endregion
//#region Middlewares
///**Allow to use req.body into route handlers */
app.use(body_parser_1.default.json());
//#endregion
/**Application routing */
app.use(routes_1.default);
/**Start app */
app.listen(3000, function () { return console.log("Server running !"); });
//# sourceMappingURL=app.js.map