<template>
  <div id="app">
    <header class="header">
      <div class="nav-wrap">
        <div class="menu">
          Меню
        </div>
        <div class="nav">
          <router-link to="/">О проекте</router-link>
          <router-link to="/achievement">Ачивки</router-link>
          <router-link to="/rating">Рейтинг</router-link>
        </div>
      </div>
    </header>
    <router-view/>
    <footer class="footer">
      <svg class="clouds" xmlns="http://www.w3.org/2000/svg" version="1.1" width="100%" height="100" viewBox="0 0 100 100" preserveAspectRatio="none">
        <path d="M-5 100 Q 0 20 5 100 Z M0 100 Q 5 0 10 100 M5 100 Q 10 30 15 100 M10 100 Q 15 10 20 100 M15 100 Q 20 30 25 100 M20 100 Q 25 -10 30 100 M25 100 Q 30 10 35 100 M30 100 Q 35 30 40 100 M35 100 Q 40 10 45 100 M40 100 Q 45 50 50 100 M45 100 Q 50 20 55 100 M50 100 Q 55 40 60 100 M55 100 Q 60 60 65 100 M60 100 Q 65 50 70 100 M65 100 Q 70 20 75 100 M70 100 Q 75 45 80 100 M75 100 Q 80 30 85 100 M80 100 Q 85 20 90 100 M85 100 Q 90 50 95 100 M90 100 Q 95 25 100 100 M95 100 Q 100 15 105 100 Z"></path>
      </svg>
      <p>
        Сделано с
        <svg class="love" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 512.003 512.003">
          <path style="fill:#E8594B;" d="M256.001,105.69c19.535-49.77,61.325-87.79,113.231-87.79c43.705,0,80.225,22.572,108.871,54.44 c39.186,43.591,56.497,139.193-15.863,209.24c-37.129,35.946-205.815,212.524-205.815,212.524S88.171,317.084,50.619,281.579 C-22.447,212.495-6.01,116.919,34.756,72.339c28.919-31.629,65.165-54.44,108.871-54.44 C195.532,17.899,236.466,55.92,256.001,105.69"/>
        </svg>
        на Урбатоне &#169; Потом придумаем, 2019
      </p>
    </footer>
  </div>
</template>

<style lang="scss">
@import url('https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap&subset=cyrillic');

$primary-color: #6B54E7;
$yellow-color: #FFF246;
$white-color: #FFFFFF;
$txt-color: #404040;

#app {
  font-family: 'Open Sans', Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: $txt-color;
}

.header {
  position: fixed;
  top: 0;
  right: 0;
  z-index: 100;
}

.nav-wrap {
  position: relative;
  padding: 30px;
  text-align: right;

  &:hover .nav {
    opacity: 1;
    transform: translateY(0);
    visibility: visible;
  }

  .menu {
    display: inline-block;
    padding: 10px;
    border-radius: 3px;
    color: $txt-color;
    background-color: $yellow-color;
    box-shadow: 0 3px 1px -2px rgba(0,0,0,.2),0 2px 2px 0 rgba(0,0,0,.14),0 1px 5px 0 rgba(0,0,0,.12);
  }

  .nav {
    position: absolute;
    top: 80px;
    right: 30px;
    width: 150px;
    padding: 15px;
    text-align: center;
    opacity: 0;
    background: white;
    border-radius: 3px;
    transform: translateY(10px);
    visibility: hidden;
    transition: transform 0.3s;
    box-shadow: 0 3px 1px -2px rgba(0,0,0,.2),0 2px 2px 0 rgba(0,0,0,.14),0 1px 5px 0 rgba(0,0,0,.12);
  }

  a {
    display: block;
    margin: 0 0 10px;
    font-weight: bold;
    color: $txt-color;

    &.router-link-exact-active {
      color: $primary-color;
    }

    &:last-child {
      margin-bottom: 0;
    }
  }
}

.footer {
  position: relative;
  z-index: 1;
  padding: 30px;
  font-size: 14px;
  line-height: 1.5;

  .clouds {
    position: absolute;
    top: -100px;
    left: 0;
    right: 0;
    margin: auto;
    fill: #ffffff;
  }

  .love {
    position: relative;
    top: 6px;
    width: 20px;
    height: 20px;
    margin: 0 4px;
  }
}
</style>
