
// Xác thực số điện thoại bằng JavaScript
document.addEventListener("DOMContentLoaded", function () {
    const phoneInput = document.getElementById("phone");
    if (phoneInput) {
        phoneInput.addEventListener("input", function () {
            const phone = this.value;
            const pattern = /^[0-9]{0,11}$/;
            if (!pattern.test(phone)) {
                this.style.borderColor = "red";
            } else {
                this.style.borderColor = "#ccc";
            }
        });
    }
});
