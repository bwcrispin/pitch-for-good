export default function addCauses(volunteer, causes) {
    return`

    <section class="addCauses__background">
    <h1 class="addCauses__headline">Add additional causes to your profile:</h1>

    <div class="causes__container">
                    <ul class="cause__container__list">
                        ${causes.map(cause => {
                            return `
                                <li class="causeNameList">
                                    <label><input type="checkbox" class="cause__causeName" id="${cause.causeId}" name="causeIds" value="${cause.causeId}"><span class="cause-bold">${cause.causeName}</span></label>:   <span class="cause__description">${cause.causeDescription}</span>
                                </li>

                            `;
                        }).join('')}
                        </ul>
                          </div>
      <div class="cause__buttons">
        <div class="addCause__button"><button id=${volunteer.volunteerId} class="js-addCauses">Submit</button></div>
        <div class="back__button"><button id=${volunteer.volunteerId} class="js-back-to-dashboard">Cancel</button></div>
      </div>

  </section>
    `;
}
