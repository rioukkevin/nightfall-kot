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
    console.log(process.env.DB_CONNECTION);
    //Connect to mongo
    mongoose_1.default.connect(process.env.DB_CONNECTION, {
        useUnifiedTopology: true,
        useNewUrlParser: true
    }, function () {
        console.log('Connected du DB !');
    });
};
exports.connectToDb = connectToDb;
//# sourceMappingURL=connection.js.map