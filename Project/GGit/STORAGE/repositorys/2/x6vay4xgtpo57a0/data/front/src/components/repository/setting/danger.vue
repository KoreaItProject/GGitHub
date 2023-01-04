<template lang="">
    <div>
  <div class="general_string">위험요소</div>
        <div class="danger_div_box">
            <li
            style="list-style:none;
            padding: 16px">
                <div >
                    <button class="change_visibility">Change visibility</button>
                </div>
                <div class="change_repository_visibility">
                    <strong>Change repository visibility</strong>
                    <div class="change_repository_visibility_message">
                        This repository is currently public.
                    </div>
                </div>
            </li>
            <li
            style="list-style:none;
            padding: 16px">
                <div >
                    <button class="transfer_btn">Transfer</button>
                </div>
                <div class="transfer_ownership">
                    <strong>
                        Transfer ownership
                    </strong>
                    <div class="transfer_ownership_message">
                        Transfer this repository to another user or to an organization where you have the ability to create repositories.
                    </div>
                </div>
            </li>
            <li
            style="list-style:none;
            padding: 16px">
                <div >
                    <button class="delete_btn" >Delete this repository</button>
                </div>
                <div class="delete_this_repository">
                <strong>Delete this repository</strong>
                <div class="delete_this_repository_message">
                    Once you delete a repository, there is no going back. Please be certain.
                </div>
            </div>
            </li>
           
            

        </div>

    </div>
</template>
<script>
export default {};
</script>
<style lang="sass">
@import 'src/assets/sass/repository/setting/danger'
</style>