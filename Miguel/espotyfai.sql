--
-- Base de datos: `espotyfai`
--
CREATE DATABASE IF NOT EXISTS `espotyfai` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `espotyfai`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `followers`
--

DROP TABLE IF EXISTS `followers`;
CREATE TABLE `followers` (
  `id_follower` int(100) NOT NULL,
  `user_follower` int(100) NOT NULL,
  `user_followed` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlists`
--

DROP TABLE IF EXISTS `playlists`;
CREATE TABLE `playlists` (
  `id_playlist` int(100) NOT NULL,
  `creator_user` int(100) NOT NULL,
  `name` varchar(30) NOT NULL,
  `publica` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlists_songs`
--

DROP TABLE IF EXISTS `playlists_songs`;
CREATE TABLE `playlists_songs` (
  `id_ps` int(100) NOT NULL,
  `cf_playlist` int(100) NOT NULL,
  `cf_song` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `playlists_songs`
--

INSERT INTO `playlists_songs` (`id_ps`, `cf_playlist`, `cf_song`) VALUES
(1, 1, 1),
(2, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `songs`
--

DROP TABLE IF EXISTS `songs`;
CREATE TABLE `songs` (
  `id_song` int(100) NOT NULL,
  `name` varchar(30) NOT NULL,
  `genre` varchar(100) NOT NULL DEFAULT 'Desconocido',
  `album` varchar(30) NOT NULL DEFAULT 'Desconocido',
  `artist` varchar(30) NOT NULL DEFAULT 'Desconocido',
  `location` varchar(200) DEFAULT NULL,
  `stars` int(11) NOT NULL DEFAULT '0',
  `reproducciones` int(30) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `songs`
--

INSERT INTO `songs` (`id_song`, `name`, `genre`, `album`, `artist`, `location`, `stars`, `reproducciones`) VALUES
(1, 'Cookie Thumper', 'Rave; Hip-hop; Hip-hop alternativo', 'Donker Mag', 'Die Antwoord', NULL, 5, 0),
(2, 'Moby Dick', 'Hard rock; blues rock', 'Led Zeppelin II', 'Led Zeppelin', NULL, 5, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id_user` int(100) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `date_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_last_acces` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `user_name`, `date_reg`, `date_last_acces`, `password`) VALUES
(1, 'dsadsfsafd', '2016-05-20 16:18:06', '2016-05-20 16:18:06', 'asdfasf');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `followers`
--
ALTER TABLE `followers`
  ADD PRIMARY KEY (`id_follower`);

--
-- Indices de la tabla `playlists`
--
ALTER TABLE `playlists`
  ADD PRIMARY KEY (`id_playlist`);

--
-- Indices de la tabla `playlists_songs`
--
ALTER TABLE `playlists_songs`
  ADD PRIMARY KEY (`id_ps`);

--
-- Indices de la tabla `songs`
--
ALTER TABLE `songs`
  ADD PRIMARY KEY (`id_song`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `followers`
--
ALTER TABLE `followers`
  MODIFY `id_follower` int(100) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `playlists`
--
ALTER TABLE `playlists`
  MODIFY `id_playlist` int(100) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `playlists_songs`
--
ALTER TABLE `playlists_songs`
  MODIFY `id_ps` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `songs`
--
ALTER TABLE `songs`
  MODIFY `id_song` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;