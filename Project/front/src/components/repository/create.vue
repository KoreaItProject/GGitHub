<template>
    <div class="create_reposiroty_contanier">
        <div class="create_repository_div">
            <div>
                <p class="create_message">Create a new repository</p>
                <div class="create_message_margin">
                <p class="create_message_sub">A repository contains all project files, including the revision history. Already have a project repository elsewhere? 
                </p>
                </div>
                   
                <div>
                    
                    <span class="owner">
                        Owner
                    </span>
                    <span class="repository_name">
                        Repository name
                    </span>
                    
                </div>
            <div>    
                <div class="owner_menu">
                    <details class="js-owner-container position-relative details-reset details-overlay select-menu">
                    <summary id="repository-owner" class="btn_summary" data-menu-button="" aria-describedby="repository-owner-label" aria-haspopup="menu" role="button">
                    <img src="https://avatars.githubusercontent.com/u/78965370?s=40&amp;v=4" alt="@eak00700" size="20" height="20" width="20" data-view-component="true" class="avatar avatar-small circle mr-1">
                    eak00700
                    </summary>
                    <details-menu class="select-menu-modal position-absolute" style="z-index: 99;" src="/users/eak00700/organizations_info?owner_id=78965370" preload="" aria-labelledby="repository-owner-label" role="menu" data-focus-trap="suspended"><span class="sentinel" tabindex="0" aria-hidden="true"></span>
                    <div class="select-menu-list">


                    <label class="select-menu-item  " role="menuitemradio" aria-checked="true" tabindex="0" data-is-user-or-org="true" data-permission="yes" data-default="public" data-default-new-repo-branch="main" data-user-show-trade-controls="false" data-owner-settings-link-prefix="your" data-owner-settings-url="/settings/repositories">
                        <input class="js-repository-owner-choice js-repository-owner-is-viewer" name="owner" type="radio" value="eak00700">
                        <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-check select-menu-item-icon">
                        <path fill-rule="evenodd" d="M13.78 4.22a.75.75 0 010 1.06l-7.25 7.25a.75.75 0 01-1.06 0L2.22 9.28a.75.75 0 011.06-1.06L6 10.94l6.72-6.72a.75.75 0 011.06 0z"></path>
                    </svg>
                        <template class="js-quick-install-list-template" >
                        <div data-login="eak00700">
                    </div>

                        </template>
                        <div class="select-menu-item-text" data-menu-button-contents="">
                            <img class="avatar select-menu-item-gravatar avatar-user" alt="" src="https://avatars.githubusercontent.com/u/78965370?s=40&amp;v=4" width="20" height="20">
                            eak00700
                        </div>
                    </label>


                    <label class="select-menu-item  " role="menuitemradio" aria-checked="false" tabindex="0" data-is-user-or-org="true" data-permission="yes" data-default="private" data-default-new-repo-branch="main" data-user-show-trade-controls="false" data-owner-settings-link-prefix="KoreaItProject's" data-owner-settings-url="/organizations/KoreaItProject/settings/repository-defaults" data-org-allow-internal-repos="false" data-org-allow-private-repos="true" data-org-allow-public-repos="true" data-org-name="KoreaItProject" data-org-private-restricted-by-plan="false" data-org-show-trade-controls="false" data-org-show-upgrade="false" data-viewer-is-org-admin="true">
                    <input class="js-repository-owner-choice js-repository-owner-is-org" name="owner" type="radio" value="KoreaItProject">
                    <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-check select-menu-item-icon">
                    <path fill-rule="evenodd" d="M13.78 4.22a.75.75 0 010 1.06l-7.25 7.25a.75.75 0 01-1.06 0L2.22 9.28a.75.75 0 011.06-1.06L6 10.94l6.72-6.72a.75.75 0 011.06 0z"></path>
                    </svg>
                    <template class="js-quick-install-list-template">
                    <div data-login="KoreaItProject">
                    </div>

                    </template>
                    <div class="select-menu-item-text" data-menu-button-contents="">
                        <img class="avatar select-menu-item-gravatar" alt="" src="https://avatars.githubusercontent.com/u/112744930?s=40&amp;v=4" width="20" height="20">
                    KoreaItProject
                    </div>
                    </label>

                    </div>

                    <span class="sentinel" tabindex="0" aria-hidden="true"></span></details-menu>
                    </details>
                </div>

                <div class="repository_name_input_div">
                <span > / </span>
                <input class="repository_name_input"/>
                </div>
            </div>    
                <div class="repo_description">
                    <span>
                        Description
                    </span>
                    <span>
                        (optional)
                    </span>
                    <div>
                    <input class="description"/>
                    </div>
                </div>
                <div class="public_check">
                    <input class="public_check_input" type="checkbox"><svg height="24" aria-hidden="true" viewBox="0 0 24 24" version="1.1" width="24" data-view-component="true" class="octicon octicon-repo float-left mt-1 mr-2 color-fg-muted">
                    <path fill-rule="evenodd" d="M3 2.75A2.75 2.75 0 015.75 0h14.5a.75.75 0 01.75.75v20.5a.75.75 0 01-.75.75h-6a.75.75 0 010-1.5h5.25v-4H6A1.5 1.5 0 004.5 18v.75c0 .716.43 1.334 1.05 1.605a.75.75 0 01-.6 1.374A3.25 3.25 0 013 18.75v-16zM19.5 1.5V15H6c-.546 0-1.059.146-1.5.401V2.75c0-.69.56-1.25 1.25-1.25H19.5z"></path><path d="M7 18.25a.25.25 0 01.25-.25h5a.25.25 0 01.25.25v5.01a.25.25 0 01-.397.201l-2.206-1.604a.25.25 0 00-.294 0L7.397 23.46a.25.25 0 01-.397-.2v-5.01z"></path>
                    </svg> 
                    Public
                        <div class="public_sub">
                            Anyone on the internet can see this repository. You choose who can commit.
                        </div>
                    
                </div>
                <div class="private_check">
                    <input class="private_check_input" type="checkbox"><svg height="24" aria-hidden="true" viewBox="0 0 24 24" version="1.1" width="24" data-view-component="true" class="octicon octicon-lock color-fg-muted float-left mt-1 mr-2">
                    <path fill-rule="evenodd" d="M6 9V7.25C6 3.845 8.503 1 12 1s6 2.845 6 6.25V9h.5a2.5 2.5 0 012.5 2.5v8a2.5 2.5 0 01-2.5 2.5h-13A2.5 2.5 0 013 19.5v-8A2.5 2.5 0 015.5 9H6zm1.5-1.75C7.5 4.58 9.422 2.5 12 2.5c2.578 0 4.5 2.08 4.5 4.75V9h-9V7.25zm-3 4.25a1 1 0 011-1h13a1 1 0 011 1v8a1 1 0 01-1 1h-13a1 1 0 01-1-1v-8z"></path>
                    </svg>
                    Private
                        <div class="private_sub">
                            You choose who can see and commit to this repository.
                        </div>
                    
                </div>
                
                <div>
                    <div class="add_readme">
                        <input class="readme_check" type="checkbox"/>Add a README file

                    </div>
                </div>

                <div class="repo_create_info">
                    <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon_octicon_info_mr_1">
                    <path fill-rule="evenodd" d="M8 1.5a6.5 6.5 0 100 13 6.5 6.5 0 000-13zM0 8a8 8 0 1116 0A8 8 0 010 8zm6.5-.25A.75.75 0 017.25 7h1a.75.75 0 01.75.75v2.75h.25a.75.75 0 010 1.5h-2a.75.75 0 010-1.5h.25v-2h-.25a.75.75 0 01-.75-.75zM8 6a1 1 0 100-2 1 1 0 000 2z"></path>
                    </svg>
                    You are creating a public repository in your personal account.
                    
                </div>

                <button data-disable-with="Creating repository&amp;hellip;" type="submit" data-view-component="true" class="btn_primary_btn" >    
                    Create repository
                </button>   
            </div>
        </div>    
    </div>     
</template>

<style lang="sass">
@import "src/assets/sass/repository/create"
</style>