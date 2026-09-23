<script setup>
defineProps({
  recherche: String,
  direction: String,
  statut: String,
  categorie: String,
  tri: String,
  directions: Array,
  statuts: Array,
  categories: Array
});

defineEmits([
  "update:recherche",
  "update:direction",
  "update:statut",
  "update:categorie",
  "update:tri"
]);
</script>

<template>
  <div class="toolbar">
    <div class="search">
      <span>⌕</span>

      <input
        :value="recherche"
        placeholder="Rechercher par titre, direction, demandeur ou statut..."
        @input="$emit('update:recherche', $event.target.value)"
      />
    </div>

    <select
      :value="direction"
      @change="$emit('update:direction', $event.target.value)"
    >
      <option value="">Direction</option>
      <option
        v-for="item in directions"
        :key="item"
        :value="item"
      >
        {{ item }}
      </option>
    </select>

    <select
      :value="statut"
      @change="$emit('update:statut', $event.target.value)"
    >
      <option value="">Statut</option>
      <option
        v-for="item in statuts"
        :key="item"
        :value="item"
      >
        {{ item }}
      </option>
    </select>

    <select
      :value="categorie"
      @change="$emit('update:categorie', $event.target.value)"
    >
      <option value="">Catégorie</option>
      <option
        v-for="item in categories"
        :key="item"
        :value="item"
      >
        {{ item }}
      </option>
    </select>

    <select
      :value="tri"
      @change="$emit('update:tri', $event.target.value)"
    >
      <option value="score">Trier : score</option>
      <option value="titre">Trier : titre</option>
      <option value="direction">Trier : direction</option>
    </select>

    <button class="secondary">
      Exporter CSV
    </button>

    <button class="primary">
      + Nouvelle demande
    </button>
  </div>
</template>

<style scoped>
.toolbar {
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 14px 18px;
  border-bottom: 1px solid var(--bordure);
  flex-wrap: wrap;
}

.search {
  position: relative;
  flex: 1;
  min-width: 260px;
}

.search span {
  position: absolute;
  top: 5px;
  left: 12px;
  color: var(--texte-discret);
  font-size: 18px;
}

.search input {
  width: 100%;
  padding: 9px 12px 9px 35px;
  background: #fbfbfd;
  border: 1px solid var(--bordure);
  border-radius: 8px;
  outline: none;
}

.search input:focus,
select:focus {
  border-color: var(--bordeaux);
}

select {
  padding: 8px 10px;
  color: var(--texte-secondaire);
  background: white;
  border: 1px solid var(--bordure);
  border-radius: 8px;
  outline: none;
}

button {
  padding: 8px 12px;
  border-radius: 8px;
  cursor: pointer;
  font-size: 12px;
  font-weight: 600;
}

.secondary {
  color: var(--texte-secondaire);
  background: white;
  border: 1px solid var(--bordure);
}

.primary {
  color: white;
  background: var(--bordeaux);
  border: 1px solid var(--bordeaux);
}

.primary:hover {
  background: var(--bordeaux-fonce);
}
</style>
