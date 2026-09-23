<template>
  <header class="header">
    <div class="header-content">
      <div class="brand">
        <span class="brand-mark"></span>

        <div>
          <div class="brand-subtitle">
            SAQ · Développement numérique et intégration
          </div>

          <div class="brand-title">
            Portefeuille des demandes IA
            <span class="poc">POC</span>
          </div>
        </div>
      </div>

      <nav class="navigation">
        <button class="navigation-item active">Portefeuille</button>
        <button class="navigation-item">Nouvelle demande</button>
        <button class="navigation-item">Grille de scoring</button>
        <button class="navigation-item">Tableau de bord</button>
      </nav>

      <div class="user">
        Analyste : <strong>A. Ouedraogo</strong>
      </div>
    </div>
  </header>
</template>

<style scoped>
.header {
  position: sticky;
  top: 0;
  z-index: 50;
  background: white;
  border-bottom: 1px solid var(--bordure);
}

.header-content {
  max-width: 1560px;
  margin: 0 auto;
  padding: 14px 28px;
  display: flex;
  align-items: center;
  gap: 28px;
}

.brand {
  display: flex;
  align-items: center;
  gap: 10px;
}

.brand-mark {
  width: 26px;
  height: 26px;
  flex-shrink: 0;
  border-radius: 6px;
  background: var(--bordeaux);
}

.brand-subtitle {
  color: var(--texte-discret);
  font-family: Consolas, monospace;
  font-size: 10px;
  letter-spacing: 0.12em;
  text-transform: uppercase;
}

.brand-title {
  margin-top: 2px;
  font-size: 17px;
  font-weight: 700;
}

.poc {
  display: inline-block;
  margin-left: 6px;
  padding: 2px 8px;
  color: var(--texte-secondaire);
  background: #f1f1f5;
  border-radius: 20px;
  font-family: Consolas, monospace;
  font-size: 10px;
  font-weight: 500;
  vertical-align: 2px;
}

.navigation {
  display: flex;
  gap: 4px;
  margin-left: auto;
}

.navigation-item {
  padding: 8px 14px;
  color: var(--texte-secondaire);
  background: transparent;
  border: 0;
  border-radius: 8px;
  cursor: pointer;
  font-weight: 600;
}

.navigation-item:hover {
  background: #f1f1f5;
}

.navigation-item.active {
  color: white;
  background: var(--bordeaux);
}

.user {
  padding-left: 18px;
  color: var(--texte-discret);
  border-left: 1px solid var(--bordure);
  font-size: 12px;
  white-space: nowrap;
}

@media (max-width: 1100px) {
  .navigation {
    display: none;
  }

  .user {
    margin-left: auto;
  }
}
</style>