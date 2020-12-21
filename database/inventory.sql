-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Des 2020 pada 08.27
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `id` int(11) NOT NULL,
  `nama_kategori` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`id`, `nama_kategori`) VALUES
(2, 'celana'),
(8, 'topi'),
(12, 'Kaos Kaki'),
(22, 'kaos'),
(25, 'nyoba'),
(28, 'kategori baru');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_hp` varchar(18) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `no_hp`, `email`, `alamat`) VALUES
(75, 'hayomana', '08543333', 'hayomana@gmail.com', 'adfsafsad'),
(76, 'aryo piningit', '0895667899', 'aryo@gmail.com', ' jl kenangan mantan'),
(77, 'subardi', '088779856', 'subardi@gmail.com', ' jl kenangan abadi ');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemasok`
--

CREATE TABLE `pemasok` (
  `id_pemasok` int(11) NOT NULL,
  `nama` varchar(70) NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `email` varchar(40) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pemasok`
--

INSERT INTO `pemasok` (`id_pemasok`, `nama`, `no_hp`, `email`, `alamat`) VALUES
(1, 'pt data sempurnaaaa', '085677788999', 'dataabadi@mail.commm', 'kyuuu'),
(2, 'PT garmen murah jaya', '02917777777', 'garmenmurah@garmen.com', 'jl magelang'),
(7, 'hyung ', '0000000000000', 'hyung@mail.com', 'hhhhh'),
(11, 'pt handal ', '00000000000000', 'handal@mail.com', 'asdfasdf'),
(14, 'pt aku bisa', '99999999999999', 'bisa@mail.com', 'asdfasdf'),
(27, 'testSupplier', '08943211112', 'test@mail.com', 'jl kengangan baru'),
(28, 'contoh', '086666555', 'supplier@gmail.com', 'asdf');

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk`
--

CREATE TABLE `produk` (
  `id_produk` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `harga_jual` int(11) DEFAULT NULL,
  `harga_awal` int(11) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `gambar` varchar(255) NOT NULL,
  `kategori_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL DEFAULT 1,
  `pemasok_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `produk`
--

INSERT INTO `produk` (`id_produk`, `nama`, `harga_jual`, `harga_awal`, `stok`, `gambar`, `kategori_id`, `status_id`, `pemasok_id`) VALUES
(10, 'Kaos polo', 90000, 50000, 0, 'kaos-polo-2.png', 22, 2, 2),
(12, 'Celana cargo pendek', 70000, 40000, 15, 'cargo-pendek.jpg', 2, 2, 1),
(13, 'celana ', 80000, 30000, 10, 'celana-jogger.jpg', 2, 2, 7),
(14, 'a', 20000, 500, 10, '', 28, 2, 28);

-- --------------------------------------------------------

--
-- Struktur dari tabel `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `nama` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `status`
--

INSERT INTO `status` (`id`, `nama`) VALUES
(1, 'menunggu'),
(2, 'disetujui'),
(3, 'ditolak'),
(4, 'aaa'),
(5, '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tipe`
--

CREATE TABLE `tipe` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `kategori_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tipe`
--

INSERT INTO `tipe` (`id`, `nama`, `kategori_id`) VALUES
(1, 'celana  anak', 2),
(2, 'celana dewasa', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `jumlah_order` int(11) DEFAULT NULL,
  `total_harga` int(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `produk_id` int(11) NOT NULL,
  `pelanggan_id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `jumlah_order`, `total_harga`, `tanggal`, `produk_id`, `pelanggan_id`, `created_at`, `updated_at`) VALUES
(108, 1, 90000, '2020-12-18', 10, 76, '2020-12-18 08:29:13', '2020-12-18 08:29:13'),
(109, 1, 90000, '2020-12-18', 10, 76, '2020-12-18 08:34:13', '2020-12-18 08:34:13'),
(110, 1, 90000, '2020-12-18', 10, 76, '2020-12-18 08:34:46', '2020-12-18 08:34:46'),
(117, 1, 90000, '2020-12-20', 10, 75, '2020-12-20 03:56:50', '2020-12-20 03:56:50'),
(118, 1, 90000, '2020-12-20', 10, 75, '2020-12-20 04:06:21', '2020-12-20 04:06:21'),
(121, 10, 900000, '2020-12-21', 10, 75, '2020-12-21 03:53:45', '2020-12-21 03:53:45'),
(122, 1, 90000, '2021-01-01', 10, 76, '2021-01-01 08:29:13', '2020-12-18 08:29:13'),
(123, 1, 90000, '2021-01-02', 10, 76, '2020-12-18 08:34:13', '2020-12-18 08:34:13'),
(124, 1, 90000, '2021-01-03', 10, 76, '2020-12-18 08:34:46', '2020-12-18 08:34:46'),
(125, 1, 90000, '2021-01-04', 10, 75, '2020-12-20 03:56:50', '2020-12-20 03:56:50'),
(126, 1, 90000, '2020-12-02', 10, 75, '2020-12-20 04:06:21', '2020-12-20 04:06:21'),
(127, 10, 900000, '2021-01-02', 10, 75, '2020-12-21 03:53:45', '2020-12-21 03:53:45'),
(128, 1, 90000, '2020-11-04', 10, 76, '2020-12-18 08:29:13', '2020-12-18 08:29:13'),
(129, 1, 90000, '2020-11-09', 10, 76, '2020-12-18 08:34:13', '2020-12-18 08:34:13'),
(130, 1, 90000, '2020-11-09', 10, 76, '2020-12-18 08:34:46', '2020-12-18 08:34:46'),
(131, 1, 90000, '2020-11-01', 10, 75, '2020-12-20 03:56:50', '2020-12-20 03:56:50'),
(132, 1, 90000, '2020-10-08', 10, 75, '2020-12-20 04:06:21', '2020-12-20 04:06:21'),
(133, 10, 900000, '2020-10-04', 10, 75, '2020-12-21 03:53:45', '2020-12-21 03:53:45'),
(134, 1, 90000, '2021-01-01', 10, 76, '2021-01-01 08:29:13', '2020-12-18 08:29:13'),
(135, 1, 90000, '2021-01-02', 10, 76, '2020-12-18 08:34:13', '2020-12-18 08:34:13'),
(136, 1, 90000, '2021-01-03', 10, 76, '2020-12-18 08:34:46', '2020-12-18 08:34:46'),
(137, 1, 90000, '2021-01-04', 10, 75, '2020-12-20 03:56:50', '2020-12-20 03:56:50'),
(138, 1, 90000, '2020-12-02', 10, 75, '2020-12-20 04:06:21', '2020-12-20 04:06:21'),
(139, 10, 900000, '2021-01-02', 10, 75, '2020-12-21 03:53:45', '2020-12-21 03:53:45');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `alamat` text NOT NULL,
  `no_hp` varchar(18) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` tinyint(2) NOT NULL DEFAULT 1,
  `roles` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `nama`, `alamat`, `no_hp`, `password`, `active`, `roles`) VALUES
(1, 'admin', 'jl lodok', '08543333221', '$2a$10$ce0bGHJhOqqGtF3IHjN9ge2GZpaeGaQ4cKM6oB5uAahaOKJgJ1vhW', 1, 'ROLE_ADMIN'),
(2, 'kepala', 'Jl Merdeka', '21211212', '$2a$10$/jERXAy7yzXV8pId5.MQruVFk1X3.Jhw9PnFYDFpRQIHkHxj.Mzpq', 1, 'ROLE_KEPALAGUDANG'),
(3, 'keuangan', 'jl kutilang indah', '087776655', '$2a$10$sdYqUJ6oELPdwTvNoB3Msu0/qjh1qIOgZ4qdsrHbTh0xIZqDT0.Vq', 1, 'ROLE_KEUANGAN'),
(4, 'pemilik', 'jl jambu air', '0856778899', '$2a$10$Y8KQ68HtPQ/l1ASb8GG0hO.ZKjnVVXTnuZTTKKMVQLWoOL/wCADeW', 1, 'ROLE_PEMILIK');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indeks untuk tabel `pemasok`
--
ALTER TABLE `pemasok`
  ADD PRIMARY KEY (`id_pemasok`);

--
-- Indeks untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id_produk`),
  ADD KEY `kategori_id` (`kategori_id`),
  ADD KEY `status_id` (`status_id`),
  ADD KEY `pemasok_id` (`pemasok_id`);

--
-- Indeks untuk tabel `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tipe`
--
ALTER TABLE `tipe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kategori_id` (`kategori_id`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `pelanggan_id` (`pelanggan_id`),
  ADD KEY `produk_id` (`produk_id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_pelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT untuk tabel `pemasok`
--
ALTER TABLE `pemasok`
  MODIFY `id_pemasok` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT untuk tabel `produk`
--
ALTER TABLE `produk`
  MODIFY `id_produk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `tipe`
--
ALTER TABLE `tipe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=140;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD CONSTRAINT `produk_ibfk_1` FOREIGN KEY (`kategori_id`) REFERENCES `kategori` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `produk_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `produk_ibfk_3` FOREIGN KEY (`pemasok_id`) REFERENCES `pemasok` (`id_pemasok`);

--
-- Ketidakleluasaan untuk tabel `tipe`
--
ALTER TABLE `tipe`
  ADD CONSTRAINT `tipe_ibfk_1` FOREIGN KEY (`kategori_id`) REFERENCES `kategori` (`id`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`produk_id`) REFERENCES `produk` (`id_produk`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`pelanggan_id`) REFERENCES `pelanggan` (`id_pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
