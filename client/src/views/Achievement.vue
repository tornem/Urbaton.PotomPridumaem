<template>
  <div class="achievement-page">
    <div class="filter-wrap">
      <v-text-field
        class="filter-input"
        label="Введите автора или название ачивки"
        v-model="searchQuery"
        solo
      />
      <svg class="down" xmlns="http://www.w3.org/2000/svg" version="1.1" width="100%" height="100" viewBox="0 0 100 100" preserveAspectRatio="none">
        <path d="M0 0 C 50 100 80 100 100 0 Z"></path>
      </svg>
    </div>
    <v-container>
      <h2 class="heading">Список авторов</h2>
      <v-progress-circular
        v-if="loader"
        :size="70"
        :width="7"
        color="#6B54E7"
        indeterminate
      />
      <v-expansion-panel v-else expand>
        <v-expansion-panel-content
          v-for="(author, authorIndex) in filteredAuthors"
          :key="author.id"
        >
          <template v-slot:header>
            <v-avatar
              size="70px"
              color="grey lighten-4"
              class="company-avatar"
            >
              <img :src="`https://picsum.photos/500/300?image=${authorIndex * 18 + 10}`" alt="avatar">
            </v-avatar>
            <div>{{author.first_name}}</div>
          </template>
          <v-card>
            <v-card-text class="grey lighten-4">
              <v-list three-line subheader v-if="author.achievements_owner.length > 0">
                <v-list-tile
                  v-for="(achievement, achievementIndex) in author.achievements_owner"
                  :key="achievement.id"
                  avatar
                  class="achievement-item"
                >
                  <v-list-tile-avatar>
                    <img :src="`https://picsum.photos/500/300?image=${achievementIndex * 5 + 10}`">
                  </v-list-tile-avatar>

                  <v-list-tile-content>
                    <v-list-tile-title>{{ achievement.name }}</v-list-tile-title>
                    <v-list-tile-sub-title v-html="achievement.description" class="achievement-description"/>
                  </v-list-tile-content>

                  <div
                    class="achievement-cost"
                  >
                    <div class="ml-2 grey--text text--darken-2">
                      <span>{{achievement.cost}}</span>
                    </div>
                    <v-icon
                      color="yellow darken-2"
                    >
                      star
                    </v-icon>
                  </div>
                </v-list-tile>
              </v-list>
              <div v-else>
                У автора нет ачивок
              </div>
            </v-card-text>
          </v-card>
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-container>
  </div>
</template>

<script>
import getData from '@/helpers/getData';

export default {
  name: 'Achievement',
  mixins: [
    getData,
  ],
  data() {
    return {
      searchQuery: '',
      authors: [],
      loader: true,
    };
  },
  async created() {
    const authors = await this.getData('authors/achievement/');

    this.authors.push(...authors);
    this.loader = false;
  },
  computed: {
    filteredAuthors() {
      let { authors, searchQuery } = this;
      let result = [];
      searchQuery = searchQuery.toLowerCase();

      if (searchQuery) {
        authors.forEach((author) => {
          const authorFirstName = author.first_name;
          const authorLastName = author.last_name;

          if (
            authorFirstName !== null
            && authorLastName !== null
            && authorFirstName !== undefined
            && authorLastName !== undefined
          ) {
            const firstNameValue = authorFirstName.toLowerCase().indexOf(searchQuery) > -1;
            const lastNameValue = authorLastName.toLowerCase().indexOf(searchQuery) > -1;
            const fullName = `${authorFirstName} ${authorLastName}`;
            const fullNameValue = fullName.toLowerCase().indexOf(searchQuery) > -1;

            const achievementValue = this.filteredAchievements(author.achievements_owner);
            const hasAchievementValue = achievementValue.length > 0;

            if (firstNameValue || lastNameValue || fullNameValue || hasAchievementValue) {
              result = [
                ...result,
                {
                  ...author,
                  achievements_owner: hasAchievementValue
                    ? achievementValue : author.achievements_owner,
                },
              ];
            }
          }
        });

        authors = result;
      }

      return authors;
    },
  },
  methods: {
    filteredAchievements(achievements) {
      let { searchQuery } = this;
      let filteredAchievements = achievements;
      searchQuery = searchQuery.toLowerCase();

      if (searchQuery) {
        filteredAchievements = filteredAchievements
          .filter(item => item.name.toLowerCase().indexOf(searchQuery) > -1);
      }

      return filteredAchievements;
    },
  },
};
</script>

<style lang="scss" scoped>
  $primary-color: #6B54E7;

  .company-avatar {
    max-width: 70px;
    margin-right: 20px;
  }

  .achievement-page {
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

  .title {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
  }

  .img {
    min-height: 200px;
  }

  .item {
    max-width: 20%;
    padding: 0 10px 20px;

    @media (max-width: 1000px) {
      max-width: 30%;
    }
    @media (max-width: 720px) {
      padding: 0 0 20px;
      flex-basis: 100%;
      max-width: 100%!important;
    }
  }

  .description {
    text-align: justify;
  }
  .achievement-cost {
    display: flex;
    align-items: center;
  }
  .heading {
    margin: 0 0 30px;
    font-size: 32px;
    line-height: 1.5;
    font-weight: bold;
    text-align: left;
  }

  .achievement-item {
    padding: 15px 0;
    border-bottom: 1px solid #eee;

    &:last-child {
      border-bottom: none;
    }
  }

  .achievement-description {
    margin-top: 5px;
  }
</style>
