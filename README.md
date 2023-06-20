# LATIHAN PRAKTIKUM 12 DPBO 2023

## Janji
Saya Muhammad Rayhan Nur [2100192] mengerjakan Latihan Praktikum 12 dalam mata kuliah Desain Pemrograman Beriorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Tujuan
Program ini dibuat dalam tujuan mengeksplorasi penggunaan arsitektur MVVM (Model-View-ViewModel) dengan melakukan restrukturisasi projek.

## Alasan Menggunakan Arsitektur MVVM
MVVM menurut saya pribadi lebih mudah dalam memisahkan antara business-logic dan tampilan dibandingkan dengan MVP yang harus menggunakan kontrak. Proses debugging pada case-case di ViewModel juga saya rasa lebih mudah.

## TP5 : Perbedaan LP12 dengan TMD
Pada TMD, penyusunan struktural class-class saya sudah lebih terbayang, seperti hanya menaruh class Display (dan Menu) di View serta menaruh class Game di ViewModel. Pada TMD juga saya mendefinisikan class GameObject di Model sebagai kelas abstrak yang tidak menerapkan interface GameInterface. Untuk selengkapnya seperti berikut.

- Struktur LP12 -
1. Model
   - Player.Java
   - Snack.Java
2. View
   - Display.Java
   - Game.Java
3. ViewModel
   - Controller.Java
   - GameInterface.Java
   - GameObject.Java
   - Handler.Java

  - Struktur TMD -
1. Model
   - DBConnection.Java
   - GameObject.Java
   - LeaderboardTable.Java
   - Obstacle.Java
   - Player.Java
   - PlayerData.Java
2. View
   - Display.Java
   - Menu.Java
3. ViewModel
   - Controller.Java
   - Game.Java
   - Handler.Java
   - Music.Java
   - TableProcess.Java
  
