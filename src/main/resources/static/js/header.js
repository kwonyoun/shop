// header.js

document.addEventListener("DOMContentLoaded", function() {
    // 메뉴 항목에 마우스를 올리면 서브메뉴가 나타나도록
    const categoryItems = document.querySelectorAll("#category li");
    const subMenus = document.querySelectorAll(".sub_menu");

    categoryItems.forEach((item, index) => {
        item.addEventListener("mouseenter", () => {
            hideAllSubMenus();
            subMenus[index].classList.add("show");
        });
    });

    // 서브메뉴 외의 부분을 클릭하면 서브메뉴 숨기기
    document.addEventListener("click", function(event) {
        if (!event.target.closest("#category")) {
            hideAllSubMenus();
        }
    });

    // 검색 버튼 클릭 시 동작
    const searchButton = document.getElementById("search_icon");
    const searchInput = document.getElementById("search_area");

    searchButton.addEventListener("click", function() {
        const query = searchInput.value.trim();
        if (query) {
            // 검색 동작 수행 (예: 검색 페이지로 이동)
            window.location.href = `/search?query=${encodeURIComponent(query)}`;
        } else {
            alert("검색어를 입력해주세요.");
        }
    });

    // 서브메뉴를 숨기는 함수
    function hideAllSubMenus() {
        subMenus.forEach(menu => menu.classList.remove("show"));
    }
});
