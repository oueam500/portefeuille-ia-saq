<script setup>
import { computed } from "vue";

const props = defineProps({
  value: {
    type: String,
    default: ""
  },
  type: {
    type: String,
    default: "statut"
  }
});

const classe = computed(() => {
  const valeur = props.value.toLowerCase();

  if (props.type === "priorite") {
    if (valeur === "critique") return "critical";
    if (valeur === "haute") return "high";
    if (valeur === "moyenne") return "medium";
    return "low";
  }

  if (valeur.includes("développement")) return "development";
  if (valeur.includes("approuvé")) return "approved";
  if (valeur.includes("comité")) return "committee";
  if (valeur.includes("analyse")) return "evaluation";
  return "backlog";
});
</script>

<template>
  <span class="badge" :class="classe">
    <span class="dot"></span>
    {{ value }}
  </span>
</template>

<style scoped>
.badge {
  display: inline-flex;
  align-items: center;
  gap: 6px;
  padding: 3px 9px;
  color: var(--texte-secondaire);
  background: #f1f1f5;
  border-radius: 20px;
  font-size: 11px;
  font-weight: 600;
  white-space: nowrap;
}

.dot {
  width: 7px;
  height: 7px;
  background: var(--texte-discret);
  border-radius: 50%;
}

.critical .dot {
  background: var(--rouge);
}

.high .dot,
.evaluation .dot {
  background: var(--orange);
}

.medium .dot,
.committee .dot {
  background: var(--bleu);
}

.low .dot,
.approved .dot,
.development .dot {
  background: var(--vert);
}
</style>