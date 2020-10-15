import mongoose from "mongoose";
import dotenv from "dotenv";

const connectToDb = () => {
    //Load env variables
    dotenv.config();

    //Connect to mongo
    mongoose.connect(process.env.DB_CONNECTION!, {
        useUnifiedTopology: true,
        useNewUrlParser : true
      }, () => {
        console.log('Connected du DB !')
      });
};

export { connectToDb };
