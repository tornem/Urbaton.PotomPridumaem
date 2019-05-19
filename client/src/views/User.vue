<template>
  <v-container class="user">
    <v-progress-circular
      v-if="loader"
      :size="70"
      :width="7"
      color="#6B54E7"
      indeterminate
    />
    <div
      v-else-if="JSON.stringify(user) == '{}'"
      class="error-block"
    >
      <span>Пользователь не найден</span>

      <span class="error-smile">:(</span>
    </div>
    <section
      v-else
      class="user-layout"
    >
      <div class="info">
        <v-avatar
          size="200px"
          color="#c3c3c3"
          dark
          class="user-avatar"
        >
          <img :src="`https://picsum.photos/500/300?image=${randomNumber}`" alt="">
        </v-avatar>
        <div class="user-ratio">
          <span>{{user.score || 0}}</span>
          <v-icon class="star" color="#FFF246">star</v-icon>
        </div>
        <div mb-3 class="user-name">
          {{user.first_name}} {{user.last_name}}
        </div>
      </div>

      <div class="achievement elevation-4">
        <v-list two-line subheader>
          <v-toolbar color="#6B54E7" dark>
            <v-toolbar-title>Полученные ачивки</v-toolbar-title>
          </v-toolbar>

          <template  v-if="user.achievements.length > 0">
            <v-list-tile
              v-for="(item, i) in user.achievements"
              :key="item.id + i"
              avatar
            >
              <v-list-tile-avatar>
                <!--<img :src="item.avatar">-->
                <v-avatar
                  size="40"
                  :color="getRandomColor()"
                />
              </v-list-tile-avatar>

              <v-list-tile-content>
                <v-list-tile-title>{{ item.name }}</v-list-tile-title>
                <v-list-tile-sub-title>{{ item.date }}</v-list-tile-sub-title>
              </v-list-tile-content>

              <div class="achievement-cost">
                <div class="ml-2 grey--text text--darken-2">
                  <span>{{item.cost}}</span>
                </div>
                <v-icon color="#FFF246">star</v-icon>
              </div>
            </v-list-tile>
          </template>
           <v-list-tile v-else class="empty">
             пусто
           </v-list-tile>
        </v-list>
      </div>
    </section>
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
      loader: true,
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
  computed: {
    randomNumber() {
      const rand = 0 + Math.random() * (20 + 1 - 0);
      return Math.floor(rand) * 5 + 10;
    },
  },
  async created() {
    const id = Number(this.$route.query.userId);
    const user = await this.getDataById('user/', id);

    this.user = Object.assign({}, this.user, user);
    this.loader = false;
  },
  methods: {
    getRandomColor() {
      const letters = '0123456789ABCDEF';
      let color = '#';
      for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
      }
      return color;
    },
  },
};
</script>

<style lang="scss" scoped>
$primary-color: #6B54E7;
$yellow-color: #FFF246;
$white-color: #FFFFFF;
$gray-color: #9e9e9e;

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
  display: flex;
  justify-content: flex-start;
  align-items: flex-start;

  @media (max-width: 990px) {
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
  }
}

.info {
  position: relative;
  max-width: 200px;
  margin-right: 100px;

  @media (max-width: 990px) {
    margin-right: 0;
    margin-bottom: 30px;
  }
}

.achievement {
  flex: 1 1 auto;
  max-height: 500px;
  overflow-y: auto;

  @media (max-width: 990px) {
    width: 100%;
  }
}

.user-avatar {
  font-size: 52px;
}

.user-name {
  font-size: 34px;
  line-height: 40px;
}

.user-ratio {
  position: absolute;
  top: 0;
  right: -15px;
  display: flex;
  align-items: center;
  padding: 5px 0px 5px 15px;
  font-size: 32px;
  color: white;
  background: #6b54e7;
  border-radius: 49% 51% 73% 27% / 42% 66% 34% 58% ;
  box-shadow: 0 3px 1px -2px rgba(0,0,0,.2),
  0 2px 2px 0 rgba(0,0,0,.14),
  0 1px 5px 0 rgba(0,0,0,.12);
}

.star {
  font-size: 40px;
}

.empty {
  color: $gray-color;

  & > * {
    text-align: center;
  }
}

.achievement-cost {
  display: flex;
  align-items: center;
}
</style>
