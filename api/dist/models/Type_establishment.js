"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.TypeEstablishmentModel = void 0;
var mongoose_1 = require("mongoose");
var TypeEstablishmentSchema = new mongoose_1.Schema({
    name: {
        type: String,
        required: true,
    },
    points: {
        type: Number,
        required: true,
    },
    color: {
        type: String,
        required: true,
    }
});
var TypeEstablishmentModel = mongoose_1.model("establishmentTypes", TypeEstablishmentSchema);
exports.TypeEstablishmentModel = TypeEstablishmentModel;
//# sourceMappingURL=Type_establishment.js.map