"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
var express_1 = __importDefault(require("express"));
var users_1 = require("./users");
var establishments_1 = require("./establishments");
var typeEstablishments_1 = require("./typeEstablishments");
var transactions_1 = require("./transactions");
var authentication_1 = require("./authentication");
var passport_1 = __importDefault(require("passport"));
/**Define global router for the application */
var appRouter = express_1.default.Router();
//#region With authentication routes
var withAuthenticationRouter = express_1.default.Router();
withAuthenticationRouter.use("/users", users_1.usersRoutes);
//type d'establishments
withAuthenticationRouter.use("/establishments", establishments_1.establishmentsRoutes);
//establishments
withAuthenticationRouter.use("/types-establishment", typeEstablishments_1.typesEstablishmentRoutes);
//transactions
withAuthenticationRouter.use("/transactions", transactions_1.transactionsRoutes);
//#endregion
//#region Without authentication routes
var withoutAuthenticationRouter = express_1.default.Router();
//Authentication
withoutAuthenticationRouter.use("/auth", authentication_1.authenticationRoutes);
//#endregion
appRouter.use("", withoutAuthenticationRouter);
appRouter.use("", passport_1.default.authenticate("jwt", { session: false }), withAuthenticationRouter);
exports.default = appRouter;
//# sourceMappingURL=index.js.map