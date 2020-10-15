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
Object.defineProperty(exports, "__esModule", { value: true });
exports.fakeEstablishments = void 0;
var Establishment_1 = require("../../../models/Establishment");
var Type_establishment_1 = require("../../../models/Type_establishment");
var fakeEstablishments = function () {
    return __awaiter(this, void 0, void 0, function () {
        var type_bar, type_resto, type_discotheque, establishments;
        var _this = this;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0: return [4 /*yield*/, Type_establishment_1.TypeEstablishmentModel.findOne({
                        name: "Bar",
                    }).exec()];
                case 1:
                    type_bar = _a.sent();
                    return [4 /*yield*/, Type_establishment_1.TypeEstablishmentModel.findOne({
                            name: "Restaurant",
                        }).exec()];
                case 2:
                    type_resto = _a.sent();
                    return [4 /*yield*/, Type_establishment_1.TypeEstablishmentModel.findOne({
                            name: "Discothèque",
                        }).exec()];
                case 3:
                    type_discotheque = _a.sent();
                    establishments = [
                        new Establishment_1.EstablishmentModel({
                            establishment_type: type_bar === null || type_bar === void 0 ? void 0 : type_bar._id,
                            name: "La Civette",
                            address: {
                                number: "2",
                                street: "pl Romain",
                                zipCode: "49100",
                                city: "Angers",
                                coordinate: {
                                    latitude: 47.473204,
                                    longitude: -0.551635,
                                },
                            },
                        }),
                        new Establishment_1.EstablishmentModel({
                            establishment_type: type_bar === null || type_bar === void 0 ? void 0 : type_bar._id,
                            name: "Le James Joyce",
                            address: {
                                number: "40",
                                street: "Boulevard Carnot",
                                zipCode: "49100",
                                city: "Angers",
                                coordinate: {
                                    latitude: 47.474032,
                                    longitude: -0.545825,
                                },
                            },
                        }),
                        new Establishment_1.EstablishmentModel({
                            establishment_type: type_resto === null || type_resto === void 0 ? void 0 : type_resto._id,
                            name: "Chez Pont-pont",
                            address: {
                                number: "13",
                                street: "Promenade du Bout du Monde",
                                zipCode: "49100",
                                city: "Angers",
                                coordinate: {
                                    latitude: 47.470281,
                                    longitude: -0.558083,
                                },
                            },
                        }),
                        new Establishment_1.EstablishmentModel({
                            establishment_type: type_resto === null || type_resto === void 0 ? void 0 : type_resto._id,
                            name: "La Ferme",
                            address: {
                                number: "2",
                                street: "Place Freppel",
                                zipCode: "49100",
                                city: "Angers",
                                coordinate: {
                                    latitude: 47.470666,
                                    longitude: -0.555754,
                                },
                            },
                        }),
                        new Establishment_1.EstablishmentModel({
                            establishment_type: type_discotheque === null || type_discotheque === void 0 ? void 0 : type_discotheque._id,
                            name: "La Carré",
                            address: {
                                number: "15",
                                street: "Rue de la Roë",
                                zipCode: "49100",
                                city: "Angers",
                                coordinate: {
                                    latitude: 47.473243,
                                    longitude: -0.553601,
                                },
                            },
                        }),
                    ];
                    establishments.forEach(function (establishment) { return __awaiter(_this, void 0, void 0, function () {
                        return __generator(this, function (_a) {
                            switch (_a.label) {
                                case 0: return [4 /*yield*/, establishment.save()];
                                case 1:
                                    _a.sent();
                                    return [2 /*return*/];
                            }
                        });
                    }); });
                    return [2 /*return*/];
            }
        });
    });
};
exports.fakeEstablishments = fakeEstablishments;
//# sourceMappingURL=establishments.js.map