"use strict";
var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    Object.defineProperty(o, k2, { enumerable: true, get: function() { return m[k]; } });
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
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
exports.authenticationRoutes = void 0;
var bcrypt = __importStar(require("bcrypt"));
var express_1 = __importDefault(require("express"));
var jwt = __importStar(require("jsonwebtoken"));
var passport_1 = __importDefault(require("passport"));
var authentication_helper_1 = require("../helpers/authentication.helper");
var password_helpers_1 = require("../helpers/password.helpers");
var User_1 = require("../models/User");
var authenticationRoutes = express_1.default.Router();
exports.authenticationRoutes = authenticationRoutes;
/**Login into the application */
authenticationRoutes.post("/login", function (req, res) { return __awaiter(void 0, void 0, void 0, function () {
    var loginInformation;
    return __generator(this, function (_a) {
        loginInformation = req.body;
        if (!(loginInformation.email && loginInformation.password)) {
            res.status(500);
            res.json("Email or password are not correct");
        }
        else {
            //Authenticate with passport
            passport_1.default.authenticate("local", { session: false }, function (err, user, info) {
                //Authentication error
                if (err || !user) {
                    return res.status(400).json({
                        message: info.message,
                        user: null,
                    });
                }
                req.login(user, { session: false }, function (err) {
                    if (err) {
                        res.send(err);
                    }
                    try {
                        // generate a signed json web token with the contents of user object and return it in the response
                        var token = jwt.sign(user, authentication_helper_1.JWT_SECRET_KEY, {
                            expiresIn: "1d",
                        });
                        return res.status(200).json({ user: user, token: token });
                    }
                    catch (error) {
                        return res.status(500).json({
                            message: "Error while generating the token. Please contact the administrator",
                            user: null,
                        });
                    }
                });
            })(req, res);
        }
        return [2 /*return*/];
    });
}); });
/**Method to sign up in the application */
authenticationRoutes.post("/signup", function (req, res) { return __awaiter(void 0, void 0, void 0, function () {
    var createUserDto, user, _a, error_1;
    return __generator(this, function (_b) {
        switch (_b.label) {
            case 0:
                createUserDto = req.body;
                if (!!((createUserDto === null || createUserDto === void 0 ? void 0 : createUserDto.email) && (createUserDto === null || createUserDto === void 0 ? void 0 : createUserDto.password))) return [3 /*break*/, 1];
                res.status(500);
                res.json("Email and password are mandatories");
                return [3 /*break*/, 7];
            case 1:
                if (!(createUserDto.password.length < 5)) return [3 /*break*/, 2];
                res.status(500);
                res.json("Password is too short");
                return [3 /*break*/, 7];
            case 2:
                _a = {
                    email: createUserDto.email,
                    firstname: createUserDto.firstname,
                    lastname: createUserDto.lastname
                };
                return [4 /*yield*/, bcrypt.hash(createUserDto.password, password_helpers_1.PASSWORD_SALT_NUMBER)];
            case 3:
                user = (_a.password = _b.sent(),
                    _a);
                _b.label = 4;
            case 4:
                _b.trys.push([4, 6, , 7]);
                return [4 /*yield*/, new User_1.UserModel(__assign({}, user)).save({
                        validateBeforeSave: true,
                    })];
            case 5:
                _b.sent();
                res.status(201);
                res.json(user);
                return [3 /*break*/, 7];
            case 6:
                error_1 = _b.sent();
                res.status(500);
                res.json("Impossible to create a new user: " + error_1.message);
                return [3 /*break*/, 7];
            case 7: return [2 /*return*/];
        }
    });
}); });
//# sourceMappingURL=authentication.js.map