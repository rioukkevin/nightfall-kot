"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.usersRoutes = void 0;
var express_1 = __importDefault(require("express"));
var User_1 = require("../models/User");
var user_service_1 = require("../services/user.service");
var usersRoutes = express_1.default.Router();
exports.usersRoutes = usersRoutes;
/**Get the ranking */
usersRoutes.get("/ranking", function (req, res) { return __awaiter(void 0, void 0, void 0, function () {
    var period, _a, _b;
    return __generator(this, function (_c) {
        switch (_c.label) {
            case 0:
                period = req.query.period;
                console.log("Asked period is " + period);
                if (!!period) return [3 /*break*/, 1];
                res.statusCode = 400;
                res.json("Query parameter period is required but not provided in the request.");
                return [3 /*break*/, 3];
            case 1:
                res.statusCode = 200;
                _b = (_a = res).json;
                return [4 /*yield*/, user_service_1.getRanking(period)];
            case 2:
                _b.apply(_a, [_c.sent()]);
                _c.label = 3;
            case 3: return [2 /*return*/];
        }
    });
}); });
usersRoutes.get("/:id", function (req, res) { return __awaiter(void 0, void 0, void 0, function () {
    var user, _a, _b, _c;
    return __generator(this, function (_d) {
        switch (_d.label) {
            case 0: return [4 /*yield*/, User_1.UserModel.findById(req.params.id)];
            case 1:
                user = (_d.sent());
                _b = (_a = res).json;
                _c = {
                    firstname: user.firstname,
                    lastname: user.lastname,
                    email: user.email
                };
                return [4 /*yield*/, User_1.countPointsLastYear(user)];
            case 2:
                _c.countPointsLastYear = _d.sent();
                return [4 /*yield*/, User_1.countPointsLastMonth(user)];
            case 3:
                _b.apply(_a, [(_c.countPointsLastMonth = _d.sent(),
                        _c)]);
                return [2 /*return*/];
        }
    });
}); });
//# sourceMappingURL=users.js.map