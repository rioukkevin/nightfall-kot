"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.connectToDb = void 0;
var mongoose_1 = __importDefault(require("mongoose"));
var dotenv_1 = __importDefault(require("dotenv"));
var connectToDb = function () {
    //Load env variables
    dotenv_1.default.config();
    //Connect to mongo
    mongoose_1.default.connect(process.env.DB_CONNECTION, {
        useUnifiedTopology: true,
        useNewUrlParser: true,
    }, function (error) {
        var _a;
        console.log("Error while trying to connect to the mongo database : " + ((_a = error === null || error === void 0 ? void 0 : error.message) !== null && _a !== void 0 ? _a : ""));
    });
};
exports.connectToDb = connectToDb;
//# sourceMappingURL=connection.js.map