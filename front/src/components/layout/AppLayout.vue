<script setup>
import AppHeader from "./AppHeader.vue";
import PortefeuilleView from "../../views/PortefeuilleView.vue";
</script>

<template>
  <AppHeader />

  <main class="main">
    <PortefeuilleView />
  </main>
</template>

<style scoped>
.main {
  width: 100%;
  max-width: 1560px;
  margin: 0 auto;
  padding: 26px 28px 80px;
}
</style>