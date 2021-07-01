// || Imports
const express = require('express');
const { json, urlencoded } = require('body-parser');
const cors = require('cors');
const database = require('./app/models');

// || Configuration
const corsOptions = {
    origin: [
        'http://localhost:8082',
        'external_url_here'
    ],
    default: 'https://localhost:8082'
};

const app = express();
//app.use(cors(corsOptions));
app.use(json());
app.use(urlencoded({ extended: true }));

//database.sequelize.sync({ force: true })...
database.sequelize.sync().then(() => console.log(new Date(), ': Drop and resync database!'));

// || Routes

app.get('/', (req, res) => {
    res.json({ message: 'Welcome to Yu-Gi-Oh Forbidden Memories API!' });
});

/*
app.all('*', (req, res, next) => {
    const header = req.header('origin').toLowerCase();
    const indexOf = corsOptions.origin.indexOf(header);
    const origin = (indexOf > -1 ? req.headers.origin : corsOptions.default);
    res.header('Access-Control-Allow-Origin', origin);
    res.header('Access-Control-Allow-Headers', 'Origin, X-Request-With, Content-Type, Accept');
    next();
});
*/

// routes(app);

const PORT = process.env.PORT || 8081;
app.listen(PORT, () => console.log(new Date(), ': Server is running on', PORT));