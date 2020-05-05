const revealHiddenDiv = () => {
    let hiddenDiv = document.getElementById("hiddenDiv");
    if (hiddenDiv.style.display === "none") {
        hiddenDiv.style.display = "block";
    } else {
        hiddenDiv.style.display = "none";
    }
};