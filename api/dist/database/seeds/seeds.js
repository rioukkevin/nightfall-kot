"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var type_establishments_1 = require("./entities/type_establishments");
var connection_1 = require("../connection");
connection_1.connectToDb();
type_establishments_1.seed().finally(function () {
    console.log("All seeds have been added");
    process.exit();
});
//# sourceMappingURL=seeds.js.map