<template>
  <router-view />
</template>

<style>
@font-face {
  font-family: "RobotoMono";
  src: url(../public/fonts/RobotoMono-Light.ttf);
  font-weight: 300;
  font-style: normal;
}
@font-face {
  font-family: "RobotoMono";
  src: url(../public/fonts/RobotoMono-Regular.ttf);
  font-weight: 400;
  font-style: normal;
}
@font-face {
  font-family: "RobotoMono";
  src: url(../public/fonts/RobotoMono-Medium.ttf);
  font-weight: 500;
  font-style: normal;
}
@font-face {
  font-family: "Montserrat";
  src: url(../public/fonts/Montserrat-Regular.ttf);
  font-weight: 400;
  font-style: normal;
}
@font-face {
  font-family: "Montserrat";
  src: url(../public/fonts/Montserrat-Medium.ttf);
  font-weight: 500;
  font-style: normal;
}

h1 {
  font-family: "Montserrat";
  font-size: 93px;
  font-weight: 300;
  letter-spacing: -1.5px;
}
h2 {
  font-family: "Montserrat";
  font-size: 58px;
  font-weight: 300;
  letter-spacing: -0.5px;
}
h3 {
  font-family: "Montserrat";
  font-size: 47px;
  font-weight: 400;
  letter-spacing: 0px;
}
h4 {
  font-family: "Montserrat";
  font-size: 33px;
  font-weight: 400;
  letter-spacing: 0.25px;
  margin: 0;
}
h5 {
  font-family: "RobotoMono";
  font-size: 23px;
  font-weight: 400;
  letter-spacing: 0px;
  margin: 0;
}
h6 {
  font-family: "Montserrat";
  font-size: 19px;
  font-weight: 500;
  letter-spacing: 0.15px;
}
.subtitle1 {
  font-family: "RobotoMono";
  font-size: 16px;
  font-weight: 400;
  letter-spacing: 0.15px;
}
.subtitle2 {
  font-family: "RobotoMono";
  font-size: 14px;
  font-weight: 500;
  letter-spacing: 0.1px;
}
.body1 {
  font-family: "Montserrat";
  font-size: 16px;
  font-weight: 400;
  letter-spacing: 0.5px;
}
.body2 {
  font-family: "Montserrat";
  font-size: 14px;
  font-weight: 400;
  letter-spacing: 0.25px;
}
.button {
  font-family: "Montserrat";
  font-size: 14px;
  font-weight: 500;
  letter-spacing: 1.25px;
}
.caption {
  font-family: "Montserrat";
  font-size: 12px;
  font-weight: 400;
  letter-spacing: 0.4px;
}
.overline {
  font-family: "Montserrat";
  font-size: 10px;
  font-weight: 400;
  letter-spacing: 1.5px;
}
button {
  border: none;
  background: none;
  padding: 0;
  transition: color 100ms 0ms cubic-bezier(0.4, 0, 0.2, 1),
    background-color 100ms 0ms cubic-bezier(0.4, 0, 0.2, 1);
}
i {
  line-height: normal;
  position: absolute;
  top: 0;
  right: 0;
}
a {
  text-decoration: none;
  color: #1f2833;
  transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out,
    border-color 0.15s ease-in-out;
}
a:hover {
  color: #00cfd3;
}

#app {
  font-family: "Montserrat", "RobotoMono", Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 0;
  background-color: #f0f0f0;
  text-decoration: none;
}
</style>
