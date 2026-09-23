<script setup>
defineProps({
  value: {
    type: [String, Number],
    default: "—"
  },
  label: {
    type: String,
    required: true
  }
});
</script>

<template>
  <div class="kpi">
    <div class="kpi-value">{{ value }}</div>
    <div class="kpi-label">{{ label }}</div>
  </div>
</template>

<style scoped>
.kpi {
  padding: 16px 18px;
  background: white;
  border: 1px solid var(--bordure);
  border-radius: 10px;
}

.kpi-value {
  font-size: 28px;
  font-weight: 700;
  letter-spacing: -0.03em;
}

.kpi-label {
  margin-top: 2px;
  color: var(--texte-discret);
  font-family: Consolas, monospace;
  font-size: 11px;
  letter-spacing: 0.08em;
  text-transform: uppercase;
}
</style>