<script setup>
import AppLayout from "./components/layout/AppLayout.vue";
</script>

<template>
  <AppLayout />
</template>

<style>
:root {
  --bordeaux: #8e1f45;
  --bordeaux-fonce: #6e1735;
  --texte: #1b1b1f;
  --texte-secondaire: #4a4a55;
  --texte-discret: #8a8a96;
  --bordure: #e4e4ea;
  --fond: #f7f7f9;
  --blanc: #ffffff;
  --vert: #1e8e5a;
  --orange: #c8811a;
  --rouge: #c0392b;
  --bleu: #2b5fa8;
}

* {
  box-sizing: border-box;
}

body {
  margin: 0;
  color: var(--texte);
  background: var(--fond);
  font-family:
    -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Arial, sans-serif;
  font-size: 14px;
}

button,
input,
select {
  font: inherit;
}
</style>