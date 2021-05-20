<template>
  <b-breadcrumb>
    <b-breadcrumb-item href="#home">
      <b-icon icon="house-fill" scale="1.25" shift-v="1.25" aria-hidden="true"></b-icon>
      <router-link to="/vuetest/"> HappyHouse</router-link>
    </b-breadcrumb-item>
    <b-breadcrumb-item href="/vuetest/apt"
      ><router-link to="/vuetest/apt">아파트정보</router-link></b-breadcrumb-item
    >
    <b-breadcrumb-item href="#about"
      ><router-link to="/vuetest/about">About</router-link></b-breadcrumb-item
    >
  </b-breadcrumb>
</template>

<script>
export default {
  name: 'Header',
};
</script>
