<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <div class="rating-page">
    <div class="filter-wrap">
      <v-text-field
        class="filter-input"
        label="Введите имя или фамилию пользователя пользователя"
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
          <v-progress-circular
            v-if="loader"
            :size="70"
            :width="7"
            color="#6B54E7"
            indeterminate
          />
          <router-link
            class="users__item"
            v-else
            v-for="(item, i) in filteredRatings"
            :key="item.id"
            :to="`/user?userId=${item.id}`"
          >
            <v-list-tile
              avatar
              size="100px"
            >
              <v-list-tile-avatar>
                <img
                  :src="`https://picsum.photos/500/300?image=${i * 2 + 5}`"
                >
              </v-list-tile-avatar>

              <v-list-tile-content>
                <v-list-tile-title>
                  {{item.first_name}} {{item.last_name}}
                </v-list-tile-title>
                <v-list-tile-sub-title>
                  {{rating[item.id]}} место
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
                  <span>{{item.score || 0}}</span>
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
import getData from '@/helpers/getData';

export default {
  mixins: [
    getData,
  ],
  data() {
    return {
      tempUsers: [],
      users: [],
      searchQuery: '',
      loader: true,
      rating: {},
    };
  },
  async created() {
    let users = await this.getData('user/');

    if (users.length === 0) {
      users = this.tempUsers;
    }

    users.sort((a, b) => {
      if (a.score < b.score) {
        return 1;
      }
      if (a.score > b.score) {
        return -1;
      }

      return 0;
    });

    users.forEach((item, i) => {
      this.rating[item.id] = i + 1
    });

    this.users.push(...users);
    this.loader = false;
  },
  computed: {
    filteredRatings() {
      let { users, searchQuery } = this;
      searchQuery = searchQuery.toLowerCase();

      if (searchQuery) {
        users = users.filter((user) => {
          const userFirstName = user.first_name;
          const userLastName = user.last_name;

          if (
            userFirstName !== null
            && userLastName !== null
            && userFirstName !== undefined
            && userLastName !== undefined
          ) {
            const firstNameValue = userFirstName.toLowerCase().indexOf(searchQuery) > -1;
            const lastNameValue = userLastName.toLowerCase().indexOf(searchQuery) > -1;
            const fullName = `${userFirstName} ${userLastName}`;
            const fullNameValue = fullName.toLowerCase().indexOf(searchQuery) > -1;

            return firstNameValue || lastNameValue || fullNameValue;
          }

          return false;
        });
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
    padding: 65px 20px 0;
  }
}

.filter-input {
  width: 100%;
  max-width: calc(1024px - 60px);
  margin: auto!important;
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
