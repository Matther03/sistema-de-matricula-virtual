const changeTitle = (currentPageName) => {
    document
        .querySelector('title')
            .innerText = `I.E. Victor Manuel Maurtua | ${currentPageName}`;
};

export default changeTitle;