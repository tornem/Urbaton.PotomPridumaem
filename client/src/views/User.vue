<template>
  <v-container class="user">
    <div
      v-if="JSON.stringify(user) == '{}'"
      class="error-block"
    >
      <span>Пользователь не найден</span>

      <span class="error-smile">:(</span>
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
                {{user.first_name | firstLetter}}
              </v-avatar>
            </v-flex>
            <v-flex class="display-3">
              <div
                class="ratio"
              >
                <div class="ml-2 grey--text text--darken-2">
                  <span>{{user.score}}</span>
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
            {{user.first_name}} {{user.last_name}}
          </v-flex>
        </v-layout>
      </v-flex>

      <v-flex class="achievement elevation-4">
        <v-list two-line subheader>
          <template  v-if="user.achievements.length > 0">
            <v-list-tile
              v-for="(item, i) in user.achievements"
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
          </template>
           <v-list-tile>
             Ачивок еще нет
           </v-list-tile>
        </v-list>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import getDataById from '@/helpers/getDataById';

export default {
  name: 'User',
  mixins: [
    getDataById,
  ],
  data() {
    return {
      user: {},
    };
  },
  filters: {
    firstLetter(text) {
      if (text) {
        return text.substr(0, 1).toUpperCase();
      }
      return '';
    },
  },
  async created() {
    const id = Number(this.$route.params.id);
    const user = await this.getDataById('user/', id);

    this.user = Object.assign({}, this.user, user);
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

  @media (max-width: 600px) {
    flex-direction: column;
    align-items: center;
  }
  @media (max-width: 500px) {
    font-size: 18px;
  }
}

.error-smile {
  transform: translate3d(55px, -5px, 0);
  font-size: 78px;
  font-weight: bold;
  color: $yellow-color;

  @media (max-width: 500px) {
    font-size: 54px;
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
