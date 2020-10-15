"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.EstablishmentModel = void 0;
var mongoose_1 = require("mongoose");
var EstablishmentSchema = new mongoose_1.Schema({
    name: {
        type: String,
        require: true,
    },
    establishment_type: {
        type: mongoose_1.Schema.Types.ObjectId,
        ref: "establishmentTypes",
    },
    address: {
        number: {
            type: String,
            required: true,
        },
        street: {
            type: String,
            required: true,
        },
        zipCode: {
            type: String,
            required: true,
        },
        city: {
            type: String,
            required: true,
        },
        coordinate: {
            latitude: {
                type: Number,
                required: true,
            },
            longitude: {
                type: Number,
                required: true,
            },
        },
    },
});
var EstablishmentModel = mongoose_1.model("establishments", EstablishmentSchema);
exports.EstablishmentModel = EstablishmentModel;
//# sourceMappingURL=Establishment.js.map