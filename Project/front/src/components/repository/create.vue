<template>
  <div class="create_reposiroty_contanier">
    <div class="create_repository_div">
      <div>
        <p class="create_message">저장소 생성</p>
        <div class="create_message_margin">
          <p class="create_message_sub">
            하나의 저장소는 메인 저장소와 작업 저장소를 가집니다.
          </p>
        </div>

        <div class="user_name_repo_name">
          <div class="user_nickname">
            <div class="Owner_font">소유자</div>
            <div class="user_nick_input">dddddddddddddd</div>
          </div>
          <span class="user_name_repo_name_span">/</span>
          <div class="repo_name">
            <div class="Repository_name">저장소 이름</div>

            <input class="repo_name_input" v-model="repoName" />
          </div>
        </div>
        <div class="repo_intro">
          좋은 저장소 이름은 짧고 이해하기 편해야 합니다.
        </div>

        <div class="repo_description">
          <span class="Description_font"> 설명 </span>
          <span class="optional_font"> (선택) </span>
          <div>
            <textarea class="description" v-model="description"></textarea>
          </div>
        </div>
        <div class="repo_check">
          <div class="public_check" style="font-size: ">
            <input
              class="public_check_input"
              type="radio"
              v-model="pub"
              value="1"
            /><svg
              height="17px"
              viewBox="0 0 24 24"
              version="1.1"
              width="17px"
              class="octicon octicon-repo float-left mt-1 mr-2 color-fg-muted"
            >
              <path
                fill-rule="evenodd"
                d="M3 2.75A2.75 2.75 0 015.75 0h14.5a.75.75 0 01.75.75v20.5a.75.75 0 01-.75.75h-6a.75.75 0 010-1.5h5.25v-4H6A1.5 1.5 0 004.5 18v.75c0 .716.43 1.334 1.05 1.605a.75.75 0 01-.6 1.374A3.25 3.25 0 013 18.75v-16zM19.5 1.5V15H6c-.546 0-1.059.146-1.5.401V2.75c0-.69.56-1.25 1.25-1.25H19.5z"
              ></path>
              <path
                d="M7 18.25a.25.25 0 01.25-.25h5a.25.25 0 01.25.25v5.01a.25.25 0 01-.397.201l-2.206-1.604a.25.25 0 00-.294 0L7.397 23.46a.25.25 0 01-.397-.2v-5.01z"
              ></path>
            </svg>
            공개
            <div class="repo_intro">
              누구나 저장소를 방문할 수 있습니다. 다른 사람을 초대하여 협업을 할
              수 있습니다.
            </div>
          </div>
          <div class="private_check">
            <input
              class="private_check_input"
              type="radio"
              v-model="pub"
              value="0"
            /><svg
              height="18px"
              viewBox="0 0 24 24"
              version="1.1"
              width="18px"
              data-view-component="true"
              class="octicon octicon-lock color-fg-muted float-left mt-1 mr-2"
            >
              <path
                fill-rule="evenodd"
                d="M6 9V7.25C6 3.845 8.503 1 12 1s6 2.845 6 6.25V9h.5a2.5 2.5 0 012.5 2.5v8a2.5 2.5 0 01-2.5 2.5h-13A2.5 2.5 0 013 19.5v-8A2.5 2.5 0 015.5 9H6zm1.5-1.75C7.5 4.58 9.422 2.5 12 2.5c2.578 0 4.5 2.08 4.5 4.75V9h-9V7.25zm-3 4.25a1 1 0 011-1h13a1 1 0 011 1v8a1 1 0 01-1 1h-13a1 1 0 01-1-1v-8z"
              ></path>
            </svg>
            비공개
            <div class="repo_intro">소유자에게만 보여집니다.</div>
          </div>

          <div>
            <div class="add_readme">
              <input
                class="readme_check"
                type="checkbox"
                v-model="readme"
                value="true"
              />README.md 생성
            </div>
          </div>
        </div>
        <div class="repo_create_info">
          <svg
            aria-hidden="true"
            height="16"
            viewBox="0 0 16 16"
            version="1.1"
            width="16"
            data-view-component="true"
            class="octicon_octicon_info_mr_1"
          >
            <path
              fill-rule="evenodd"
              d="M8 1.5a6.5 6.5 0 100 13 6.5 6.5 0 000-13zM0 8a8 8 0 1116 0A8 8 0 010 8zm6.5-.25A.75.75 0 017.25 7h1a.75.75 0 01.75.75v2.75h.25a.75.75 0 010 1.5h-2a.75.75 0 010-1.5h.25v-2h-.25a.75.75 0 01-.75-.75zM8 6a1 1 0 100-2 1 1 0 000 2z"
            ></path>
          </svg>
          생성된 저장소는 프로필 > 저장소에 생성됩니다.
        </div>

        <button
          type="submit"
          data-view-component="true"
          class="btn_primary_btn"
          @click="create"
        >
          저장소 생성
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {
      repoName: "",
      description: "",
      pub: 1,
      readme: true,
    };
  },
  methods: {
    create: function () {
      alert(
        this.repoName +
          "\n" +
          this.description +
          "\n" +
          this.pub +
          "\n" +
          this.readme
      );
    },
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/repository/create"
</style>