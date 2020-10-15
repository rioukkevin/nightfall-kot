"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var establishments_1 = require("./entities/establishments");
var users_1 = require("./entities/users");
var transactions_1 = require("./entities/transactions");
var connection_1 = require("./../connection");
/**Connect to the DB and create mocks */
connection_1.connectToDb();
establishments_1.fakeEstablishments()
    .then(function () {
    users_1.fakeUsers()
        .then(function () {
        transactions_1.fakeTransactions().finally(function () {
            return console.log("Transactions added");
        });
    })
        .finally(function () { return console.log("Users added"); });
})
    .finally(function () {
    console.log("Establishments added. \nFinished");
});
//# sourceMappingURL=fakes.js.map