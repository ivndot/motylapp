//items
const items = document.querySelectorAll(".item");
// item phases
const phases = document.querySelector(".itemflex");
//menu
const menu = document.querySelector(".menu");
// submenu
const submenu = document.querySelector(".submenu");
// content
const content = document.querySelector(".content");
// menubutton
const menubutton = document.querySelector("#menubutton");
// dropdownicon
const dropdownicon = document.querySelector("#dropdownicon");
//elements to dissapear
const elements = document.querySelectorAll("[data-elements]");
//species
const species = document.querySelector("#species");
//plant
const plant = document.querySelector("#plant");
//egg
const egg = document.querySelector("#egg");
//larva
const larva = document.querySelector("#larva");
//pupa
const pupa = document.querySelector("#pupa");
//adult
const adult = document.querySelector("#adult");
//modal
const modal = document.querySelector(".modal-box");
//btn open modal
const btnOpenModal = document.querySelectorAll(".btn-drop");
//btn close modal
const btnCancelModal = document.querySelector(".btn-cancel");
//btn accept modal
const btnAcceptModal = document.querySelector(".btn-accept");
//title
const title = document.querySelector(".content-tittle");
//id for drop the item
let id = null;

console.log(species);

/*MENU BUTTON */
menubutton.addEventListener("click", stretchMenu);

/*COLLAPSE SUBMENU*/
phases.addEventListener("click", () => {
    collapseSubmenu();
});

/*OPEN MODAL BOX */
btnOpenModal.forEach((item) => {
    item.addEventListener("click", () => {
        modal.style.display = "block";
        //obtain id of the item
        id = item.getAttribute("data-id");
        //assign the id to the modal button accept
        btnAcceptModal.href = deleteElement(title.innerHTML) + id;
    });
});

/*CLOSE MODAL BOX */
btnCancelModal.addEventListener("click", () => {
    modal.style.display = "none";
});

window.addEventListener("click", (event) => {
    if (event.target == modal) {
        modal.style.display = "none";
    }
});

/*STRETCH MENU FUNCTION */
function stretchMenu() {
    menu.classList.toggle("menustretch");
    content.classList.toggle("contentstretch");
    //dissapear text and icon
    elements.forEach((item) => {
        item.classList.toggle("dissapearelements");
    });
}

/*FOCUS ITEM FUNCTION*/
function itemFocus(item) {
    switch (item) {
        case "species":
            species.style.backgroundColor = "#295244";
            break;
        case "plant":
            plant.style.backgroundColor = "#295244";
            break;
        case "egg":
            collapseSubmenu();
            egg.style.backgroundColor = "#658c7f";
            break;
        case "larva":
            collapseSubmenu();
            larva.style.backgroundColor = "#658c7f";
            break;
        case "pupa":
            collapseSubmenu();
            pupa.style.backgroundColor = "#658c7f";
            break;
        case "adult":
            collapseSubmenu();
            adult.style.backgroundColor = "#658c7f";
            break;
    }
}

/*KNOW THE ITEM MENU FOR DELETE AN ELEMENT */
function deleteElement(element) {
    let url = null;
    switch (element) {
        case "Especies":
            url = "delete_species.controller?id=";
            break;
        case "Plantas":
            url = "delete_plants.controller?id=";
            break;
        case "Fase huevo":
            url = "delete_egg.controller?id=";
            break;
        case "Fase larva":
            url = "delete_larva.controller?id=";
            break;
        case "Fase pupa":
            url = "delete_pupa.controller?id=";
            break;
        case "Fase Adulto":
            url = "delete_adult.controller?id=";
            break;
    }
    return url;
}

/*COLLPASE SUBMENU */
function collapseSubmenu(){
    submenu.classList.toggle("collapse-phases");
    dropdownicon.classList.toggle("fa-angle-down");
    dropdownicon.classList.toggle("fa-angle-up");
}