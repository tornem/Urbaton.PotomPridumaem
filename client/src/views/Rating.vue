<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <div class="rating-page">
    <div class="filter-wrap">
      <v-text-field
        class="filter-input"
        label="Введите логин пользователя"
        v-model="searchQuery"
        solo
      />
      <svg class="down" xmlns="http://www.w3.org/2000/svg" version="1.1" width="100%" height="100" viewBox="0 0 100 100" preserveAspectRatio="none">
        <path d="M0 0 C 50 100 80 100 100 0 Z"></path>
      </svg>
    </div>
    <v-layout
      column
    >
      <v-container>
        <v-list
          two-line
          class="users"
        >
          <h2 class="heading">Рейтинг пользователей</h2>
          <router-link
            class="users__item"
            v-for="(item, i) in filteredRatings"
            :key="item.user_id"
            :to="`/user/${item.user_id}`"
          >
            <v-list-tile
              avatar
              size="100px"
            >
              <v-list-tile-avatar>
                <img
                  :src="`https://picsum.photos/500/300?image=${i * 5 + 10}`"
                >
              </v-list-tile-avatar>

              <v-list-tile-content>
                <v-list-tile-title>
                  {{item.username}}
                </v-list-tile-title>
                <v-list-tile-sub-title>
                  {{i+1}} место
                </v-list-tile-sub-title>
              </v-list-tile-content>

              <div
                class="users__rating"
                title="количество ачивок"
              >
                <v-icon
                  color="yellow darken-2"
                >
                  star
                </v-icon>
                <div class="ml-2 grey--text text--darken-2">
                  <span>{{item.ratio}}</span>
                </div>
              </div>
            </v-list-tile>

            <v-divider></v-divider>
          </router-link>
        </v-list>
      </v-container>
    </v-layout>
  </div>
</template>

<script>
export default {
  data() {
    return {
      users: [
        {
          user_id: '1',
          username: 'Иван',
          ratio: '1',
        },
        {
          user_id: '2',
          username: 'Дмитрий',
          ratio: '2',
        },
        {
          user_id: '3',
          username: 'Олег',
          ratio: '3',
        },
        {
          user_id: '4',
          username: 'Колобок',
          ratio: '4',
        },
      ],
      searchQuery: '',
    };
  },
  computed: {
    filteredRatings() {
      let { users, searchQuery } = this;
      searchQuery = searchQuery.toLowerCase();

      if (searchQuery) {
        users = users.filter(item => item.username.toLowerCase().indexOf(searchQuery) > -1);
      }

      return users;
    },
  },
};
</script>

<style lang="scss" scoped>
  $primary-color: #6B54E7;
.rating-page {
  width: 100%;
}

.filter-wrap {
  position: relative;
  width:100%;
  padding: 95px 30px 0;
  margin-bottom: 100px;
  background-color: $primary-color;

  svg {
    position: absolute;
    left: 0;
    right: 0;
    bottom: -100px;
    margin:  auto;
    fill: $primary-color;
  }

  @media screen and (max-width: 768px) {
    padding: 65px 30px 0;
  }
}

.filter-input {
  width: 100%;
  max-width: 1024px;
  margin: auto;
}

.heading {
  margin: 0 0 30px;
  font-size: 32px;
  line-height: 1.5;
  font-weight: bold;
  text-align: left;
}

.users {
  &__item {
    text-decoration: none;

    &:hover > div {
      background-color: ghostwhite;
    }
  }
  &__rating {
    display: flex;
  }
}
</style>
