<template>
  <v-container class="user">
    <div
      v-if="selectedUser.length === 0"
      class="error-block"
    >
      Пользователь не найден

      <span>:(</span>
    </div>
    <v-layout
      v-else
      class="user-layout"
    >
      <v-flex class="info">
        <v-layout column align-start pa-4>
          <v-layout row align-center mb-3>
            <v-flex  class="display-3 mr-4">
              <v-avatar
                size="150px"
                color="green lighten-4"
              >
                {{selectedUser.username | firstLetter}}
              </v-avatar>
            </v-flex>
            <v-flex class="display-3">
              <div
                class="ratio"
              >
                <div class="ml-2 grey--text text--darken-2">
                  <span>{{selectedUser.ratio}}</span>
                </div>
                <v-icon
                  class="star"
                  color="yellow darken-2"
                >
                  star
                </v-icon>
              </div>
            </v-flex>
          </v-layout>
          <v-flex mb-3 class="display-1">
            {{selectedUser.username}}
          </v-flex>
          <v-flex mb-3 class="display-1">
            {{selectedUser.first_name}} {{selectedUser.last_name}}
          </v-flex>
        </v-layout>
      </v-flex>

      <v-flex class="achievement elevation-4">
        <v-list two-line subheader>
          <v-list-tile
            v-for="(item, i) in selectedUser.achievements"
            :key="item.id"
            avatar
          >
            <v-list-tile-avatar>
              <img :src="`https://picsum.photos/500/300?image=${i * 5 + 10}`">
            </v-list-tile-avatar>

            <v-list-tile-content>
              <v-list-tile-title>{{ item.name }}</v-list-tile-title>
              <v-list-tile-sub-title>{{ item.date }}</v-list-tile-sub-title>
            </v-list-tile-content>

            <div
              class="achievement-cost"
            >
              <div class="ml-2 grey--text text--darken-2">
                <span>{{item.cost}}</span>
              </div>
              <v-icon
                color="yellow darken-2"
              >
                star
              </v-icon>
            </div>
          </v-list-tile>
        </v-list>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: 'User',
  data() {
    return {
      users: [
        {
          user_id: 1,
          username: 'Иван',
          first_name: 'Иван',
          last_name: 'Иванов',
          data_reg: '16 января',
          ratio: 1,
          achievements: [
            {
              id: 'id1',
              name: 'ачивка номер 1',
              date: '16 января',
              cost: 15,
            },
            {
              id: 'id2',
              name: 'ачивка номер 2',
              date: '16 января',
              cost: 15,
            },
            {
              id: 'id3',
              name: 'ачивка номер 2',
              date: '16 января',
              cost: 15,
            },
            {
              id: 'id1',
              name: 'ачивка номер 1',
              date: '16 января',
              cost: 15,
            },
            {
              id: 'id2',
              name: 'ачивка номер 2',
              date: '16 января',
              cost: 15,
            },
            {
              id: 'id3',
              name: 'ачивка номер 2',
              date: '16 января',
              cost: 15,
            },
            {
              id: 'id1',
              name: 'ачивка номер 1',
              date: '16 января',
              cost: 15,
            },
            {
              id: 'id2',
              name: 'ачивка номер 2',
              date: '16 января',
              cost: 15,
            },
            {
              id: 'id3',
              name: 'ачивка номер 2',
              date: '16 января',
              cost: 15,
            },
          ],
        },
        {
          user_id: 2,
          username: 'Дмитрий',
          first_name: 'Дмитрий',
          last_name: 'Дмитриев',
          data_reg: '6 мая',
          ratio: 1,
          achievements: [
            {
              id: 'id1',
              name: 'ачивка номер 1',
              cost: 15,
            },
            {
              id: 'id2',
              name: 'ачивка номер 2',
              cost: 15,
            },
            {
              id: 'id3',
              name: 'ачивка номер 2',
              cost: 15,
            },
          ],
        },
      ],
    };
  },
  filters: {
    firstLetter(text) {
      return text.substr(0, 1).toUpperCase();
    },
  },
  computed: {
    id() {
      console.log();
    },
    selectedUser() {
      const { users } = this;
      const userId = Number(this.$route.params.id);
      const selectedUser = users.filter(item => item.user_id === userId);

      return selectedUser.length === 0 ? [] : selectedUser[0];
    },
  },
};
</script>

<style lang="scss" scoped>
$primary-color: #6B54E7;
$yellow-color: #FFF246;
$white-color: #FFFFFF;

.error-block {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 300px;
  max-width: 600px;
  margin: 100px auto 0;
  font-size: 24px;
  color: $white-color;
  background-color: $primary-color;
  border-radius: 24% 76% 56% 44% / 37% 59% 41% 63%;

  span {
    transform: translate3d(55px, -5px, 0);
    font-size: 78px;
    font-weight: bold;
    color: $yellow-color
  }
}

.user {
  margin: 100px auto 0;

  @media (max-width: 1070px) {
    max-width: 800px;
  }
}

.user-layout {
  @media (max-width: 970px) {
    flex-direction: column;
  }
}

.info,
.achievement {
  width: 50%;
  @media (max-width: 970px) {
    width: 100%;
  }
}

.achievement {
  max-height: 500px;
  overflow-y: auto;
}

.ratio {
  display: flex;
  align-items: center;
}

.star {
  font-size: 56px;
}

.achievement-cost {
  display: flex;
  align-items: center;
}
</style>
