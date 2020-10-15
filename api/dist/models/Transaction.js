"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.TransactionModel = void 0;
var mongoose_1 = require("mongoose");
var TransactionSchema = new mongoose_1.Schema({
    establishment: {
        type: mongoose_1.Schema.Types.ObjectId,
        ref: 'establishments'
    },
    user: {
        type: mongoose_1.Schema.Types.ObjectId,
        ref: "users",
    },
    date: {
        type: Date,
        default: Date.now
    }
});
var TransactionModel = mongoose_1.model("transactions", TransactionSchema);
exports.TransactionModel = TransactionModel;
//# sourceMappingURL=Transaction.js.map