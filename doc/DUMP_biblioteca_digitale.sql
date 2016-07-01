-- phpMyAdmin SQL Dump
-- version 4.4.13.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Giu 19, 2016 alle 17:33
-- Versione del server: 5.6.30-0ubuntu0.15.10.1
-- Versione PHP: 5.6.11-1ubuntu3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblioteca_digitale`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Acquisizione`
--

CREATE TABLE IF NOT EXISTS `Acquisizione` (
  `numero` int(11) DEFAULT NULL,
  `titolo` varchar(500) DEFAULT NULL,
  `note` text,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Acquisizione`
--

INSERT INTO `Acquisizione` (`numero`, `titolo`, `note`, `ID`) VALUES
(1, 'opera.jpg', NULL, 40),
(1, 'opera.jpg', NULL, 41);

-- --------------------------------------------------------

--
-- Struttura della tabella `Acq_contiene`
--

CREATE TABLE IF NOT EXISTS `Acq_contiene` (
  `acquisizione` int(11) NOT NULL DEFAULT '0',
  `trascrizione` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Acq_contiene`
--

INSERT INTO `Acq_contiene` (`acquisizione`, `trascrizione`) VALUES
(40, 10);

-- --------------------------------------------------------

--
-- Struttura della tabella `Opera`
--

CREATE TABLE IF NOT EXISTS `Opera` (
  `titolo` varchar(20) DEFAULT NULL,
  `autore` varchar(20) DEFAULT NULL,
  `lingua` varchar(20) DEFAULT NULL,
  `data_pubb` varchar(20) DEFAULT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Opera`
--

INSERT INTO `Opera` (`titolo`, `autore`, `lingua`, `data_pubb`, `ID`) VALUES
('Opera 0 ', 'Gianluca', 'italiano', '23 maggio 1980', 35),
('Opera 1', 'Gianluca', 'italiano', '20 gennaio 1800', 36);

-- --------------------------------------------------------

--
-- Struttura della tabella `Op_contiene`
--

CREATE TABLE IF NOT EXISTS `Op_contiene` (
  `opera` int(11) NOT NULL DEFAULT '0',
  `pagina` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Op_contiene`
--

INSERT INTO `Op_contiene` (`opera`, `pagina`) VALUES
(35, 34),
(36, 35);

-- --------------------------------------------------------

--
-- Struttura della tabella `Pagina`
--

CREATE TABLE IF NOT EXISTS `Pagina` (
  `numero` int(11) DEFAULT NULL,
  `pubblicata` tinyint(1) NOT NULL,
  `note` text,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Pagina`
--

INSERT INTO `Pagina` (`numero`, `pubblicata`, `note`, `ID`) VALUES
(1, 1, NULL, 34),
(1, 0, NULL, 35);

-- --------------------------------------------------------

--
-- Struttura della tabella `Pag_contiene`
--

CREATE TABLE IF NOT EXISTS `Pag_contiene` (
  `pagina` int(11) NOT NULL DEFAULT '0',
  `acquisizione` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Pag_contiene`
--

INSERT INTO `Pag_contiene` (`pagina`, `acquisizione`) VALUES
(34, 40),
(35, 41);

-- --------------------------------------------------------

--
-- Struttura della tabella `Ruolo`
--

CREATE TABLE IF NOT EXISTS `Ruolo` (
  `tipo` varchar(20) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Ruolo`
--

INSERT INTO `Ruolo` (`tipo`) VALUES
('acquisitore'),
('amministratore'),
('revisore acq'),
('revisore tras'),
('trascrittore'),
('utente');

-- --------------------------------------------------------

--
-- Struttura della tabella `Stato`
--

CREATE TABLE IF NOT EXISTS `Stato` (
  `tipo` varchar(30) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Stato`
--

INSERT INTO `Stato` (`tipo`) VALUES
('acquisito'),
('attesa acquisizione'),
('attesa revisione acq'),
('attesa revisione tras'),
('in acquisizione'),
('in revisione acq'),
('in revisione tras'),
('in trascrizione'),
('trascritto');

-- --------------------------------------------------------

--
-- Struttura della tabella `Stato_pag`
--

CREATE TABLE IF NOT EXISTS `Stato_pag` (
  `pagina` int(11) NOT NULL DEFAULT '0',
  `stato` varchar(30) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Stato_pag`
--

INSERT INTO `Stato_pag` (`pagina`, `stato`) VALUES
(35, 'in trascrizione'),
(34, 'trascritto');

-- --------------------------------------------------------

--
-- Struttura della tabella `Trascrizione`
--

CREATE TABLE IF NOT EXISTS `Trascrizione` (
  `TEI` text,
  `note` text,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Trascrizione`
--

INSERT INTO `Trascrizione` (`TEI`, `note`, `ID`) VALUES
('<?xml version="1.0" encoding="UTF-8" standalone="no"?><TEI.2 TEIform="TEI.2">\n  <teiHeader TEIform="teiHeader" status="new" type="text">\n    <fileDesc TEIform="fileDesc">\n      <titleStmt TEIform="titleStmt">\n        <title TEIform="title">Opera 0 </title>\n        <author TEIform="author">\n          <name TEIform="name">Gianluca</name>\n        </author>\n      </titleStmt>\n      <publicationStmt TEIform="publicationStmt">\n        <publisher TEIform="publisher">Gianluca Scatena</publisher>\n        <address TEIform="address">\n          <addrLine TEIform="addrLine">scatenagianluca@yahoo.it</addrLine>\n        </address>\n        <idno TEIform="idno">scagian</idno>\n      </publicationStmt>\n    </fileDesc>\n    <profileDesc TEIform="profileDesc">\n      <creation TEIform="creation">\n        <date TEIform="date">23 maggio 1980</date>\n      </creation>\n      <langUsage TEIform="langUsage" default="NO">\n        <language TEIform="language">italiano</language>\n      </langUsage>\n    </profileDesc>\n    <revisionDesc TEIform="revisionDesc">\n      <change TEIform="change">\n        <date TEIform="date">19/06/2016</date>\n        <respStmt TEIform="respStmt">scagian</respStmt>\n        <item TEIform="item">Ho cancellato un "Prova"</item>\n      </change>\n    </revisionDesc>\n  </teiHeader>\n  <text TEIform="text">\n    <front TEIform="front">\n      <titlePage TEIform="titlePage">\n        <docTitle TEIform="docTitle">\n          <titlePart TEIform="titlePart" type="main">Pagina 1</titlePart>\n        </docTitle>\n      </titlePage>\n    </front>\n    <body TEIform="body">\n      <div TEIform="div" org="uniform" part="N" sample="complete">Prova Prova Prova </div>\n    </body>\n  </text>\n</TEI.2>', NULL, 10);

-- --------------------------------------------------------

--
-- Struttura della tabella `Utente`
--

CREATE TABLE IF NOT EXISTS `Utente` (
  `nome` varchar(20) DEFAULT NULL,
  `cognome` varchar(20) DEFAULT NULL,
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Utente`
--

INSERT INTO `Utente` (`nome`, `cognome`, `username`, `password`, `email`) VALUES
('Marco', 'Labici', 'labmar', 'marco', 'marco@marco.it'),
('Maria', 'Montaldi', 'mc', 'mariacri', 'mc@homtail.it'),
('Rita', 'Palma', 'rita', 'rita', 'rita@rita.it'),
('Gianluca', 'Scatena', 'scagian', 'ciao', 'scatenagianluca@yahoo.it');

-- --------------------------------------------------------

--
-- Struttura della tabella `Utente_possiede_ruolo`
--

CREATE TABLE IF NOT EXISTS `Utente_possiede_ruolo` (
  `utente` varchar(20) NOT NULL DEFAULT '',
  `ruolo` varchar(20) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Utente_possiede_ruolo`
--

INSERT INTO `Utente_possiede_ruolo` (`utente`, `ruolo`) VALUES
('labmar', 'acquisitore'),
('scagian', 'amministratore'),
('mc', 'revisore acq'),
('rita', 'trascrittore');

-- --------------------------------------------------------

--
-- Struttura della tabella `Utente_su_Pag`
--

CREATE TABLE IF NOT EXISTS `Utente_su_Pag` (
  `utente` varchar(20) NOT NULL DEFAULT '',
  `pagina` int(11) NOT NULL DEFAULT '0',
  `closed` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Utente_su_Pag`
--

INSERT INTO `Utente_su_Pag` (`utente`, `pagina`, `closed`) VALUES
('labmar', 35, 1),
('rita', 35, 0),
('scagian', 34, 1);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Acquisizione`
--
ALTER TABLE `Acquisizione`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `Acq_contiene`
--
ALTER TABLE `Acq_contiene`
  ADD PRIMARY KEY (`acquisizione`,`trascrizione`),
  ADD KEY `ID_Trascrizione` (`trascrizione`);

--
-- Indici per le tabelle `Opera`
--
ALTER TABLE `Opera`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `Op_contiene`
--
ALTER TABLE `Op_contiene`
  ADD PRIMARY KEY (`opera`,`pagina`),
  ADD KEY `ID_Pagina` (`pagina`);

--
-- Indici per le tabelle `Pagina`
--
ALTER TABLE `Pagina`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `Pag_contiene`
--
ALTER TABLE `Pag_contiene`
  ADD PRIMARY KEY (`pagina`,`acquisizione`),
  ADD KEY `ID_Acquisizione` (`acquisizione`);

--
-- Indici per le tabelle `Ruolo`
--
ALTER TABLE `Ruolo`
  ADD PRIMARY KEY (`tipo`);

--
-- Indici per le tabelle `Stato`
--
ALTER TABLE `Stato`
  ADD PRIMARY KEY (`tipo`);

--
-- Indici per le tabelle `Stato_pag`
--
ALTER TABLE `Stato_pag`
  ADD PRIMARY KEY (`pagina`,`stato`),
  ADD KEY `stato` (`stato`);

--
-- Indici per le tabelle `Trascrizione`
--
ALTER TABLE `Trascrizione`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `Utente`
--
ALTER TABLE `Utente`
  ADD PRIMARY KEY (`username`);

--
-- Indici per le tabelle `Utente_possiede_ruolo`
--
ALTER TABLE `Utente_possiede_ruolo`
  ADD PRIMARY KEY (`utente`,`ruolo`),
  ADD KEY `ruolo` (`ruolo`);

--
-- Indici per le tabelle `Utente_su_Pag`
--
ALTER TABLE `Utente_su_Pag`
  ADD PRIMARY KEY (`utente`,`pagina`),
  ADD KEY `pagina` (`pagina`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Acquisizione`
--
ALTER TABLE `Acquisizione`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT per la tabella `Opera`
--
ALTER TABLE `Opera`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT per la tabella `Pagina`
--
ALTER TABLE `Pagina`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT per la tabella `Trascrizione`
--
ALTER TABLE `Trascrizione`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `Acq_contiene`
--
ALTER TABLE `Acq_contiene`
  ADD CONSTRAINT `Acq_contiene_ibfk_1` FOREIGN KEY (`acquisizione`) REFERENCES `Acquisizione` (`ID`),
  ADD CONSTRAINT `Acq_contiene_ibfk_2` FOREIGN KEY (`trascrizione`) REFERENCES `Trascrizione` (`ID`);

--
-- Limiti per la tabella `Op_contiene`
--
ALTER TABLE `Op_contiene`
  ADD CONSTRAINT `Op_contiene_ibfk_1` FOREIGN KEY (`opera`) REFERENCES `Opera` (`ID`),
  ADD CONSTRAINT `Op_contiene_ibfk_2` FOREIGN KEY (`pagina`) REFERENCES `Pagina` (`ID`);

--
-- Limiti per la tabella `Pag_contiene`
--
ALTER TABLE `Pag_contiene`
  ADD CONSTRAINT `Pag_contiene_ibfk_1` FOREIGN KEY (`pagina`) REFERENCES `Pagina` (`ID`),
  ADD CONSTRAINT `Pag_contiene_ibfk_2` FOREIGN KEY (`acquisizione`) REFERENCES `Acquisizione` (`ID`);

--
-- Limiti per la tabella `Stato_pag`
--
ALTER TABLE `Stato_pag`
  ADD CONSTRAINT `Stato_pag_ibfk_1` FOREIGN KEY (`pagina`) REFERENCES `Pagina` (`ID`),
  ADD CONSTRAINT `Stato_pag_ibfk_2` FOREIGN KEY (`stato`) REFERENCES `Stato` (`tipo`);

--
-- Limiti per la tabella `Utente_possiede_ruolo`
--
ALTER TABLE `Utente_possiede_ruolo`
  ADD CONSTRAINT `Utente_possiede_ruolo_ibfk_1` FOREIGN KEY (`utente`) REFERENCES `Utente` (`username`),
  ADD CONSTRAINT `Utente_possiede_ruolo_ibfk_2` FOREIGN KEY (`ruolo`) REFERENCES `Ruolo` (`tipo`);

--
-- Limiti per la tabella `Utente_su_Pag`
--
ALTER TABLE `Utente_su_Pag`
  ADD CONSTRAINT `Utente_su_Pag_ibfk_1` FOREIGN KEY (`utente`) REFERENCES `Utente` (`username`),
  ADD CONSTRAINT `Utente_su_Pag_ibfk_2` FOREIGN KEY (`pagina`) REFERENCES `Pagina` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
