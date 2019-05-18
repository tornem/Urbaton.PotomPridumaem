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
      users: [{
        user_id: 116467,
        username: 'Юрасов Богдан',
        ratio: 9742,
      },
      {
        user_id: 113963,
        username: 'Астахов Афанасий',
        ratio: 9485,
      },
      {
        user_id: 116294,
        username: 'Торсунов Фома',
        ratio: 9196,
      },
      {
        user_id: 111829,
        username: 'Яркова Евгения',
        ratio: 9174,
      },
      {
        user_id: 117416,
        username: 'Цой Юлия',
        ratio: 8660,
      },
      {
        user_id: 114642,
        username: 'Филипов Венедикт',
        ratio: 8351,
      },
      {
        user_id: 118912,
        username: 'Балинский Ян',
        ratio: 7971,
      },
      {
        user_id: 113115,
        username: 'Федченкова Ираида',
        ratio: 7936,
      },
      {
        user_id: 118006,
        username: 'Мурогова Полина',
        ratio: 7901,
      },
      {
        user_id: 112427,
        username: 'Рыжанова Ксения',
        ratio: 7731,
      },
      {
        user_id: 118755,
        username: 'Юхтриц Ефрем',
        ratio: 7560,
      },
      {
        user_id: 112790,
        username: 'Храмов Георгий',
        ratio: 6980,
      },
      {
        user_id: 113326,
        username: 'Талызин Наум',
        ratio: 6954,
      },
      {
        user_id: 113442,
        username: 'Буркина Анастасия',
        ratio: 6175,
      },
      {
        user_id: 118915,
        username: 'Покровская Софья',
        ratio: 6174,
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
