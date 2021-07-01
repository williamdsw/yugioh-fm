// || Imports
const express = require('express');
const cors = require('cors');
const database = require('./app/models');
const cardRoutes = require('./app/routes/card.routes');
const deckRoutes = require('./app/routes/deck.routes');
const gameCharacterRoutes = require('./app/routes/game-character.routes');

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

cardRoutes(app);
deckRoutes(app);
gameCharacterRoutes(app);

const PORT = process.env.PORT || 8081;
app.listen(PORT, () => console.log(new Date(), ': Server is running on', PORT));