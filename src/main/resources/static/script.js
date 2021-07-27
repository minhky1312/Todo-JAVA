const toggles = document.querySelectorAll('.faq-toggle')


toggles.forEach(toggle => {
    toggle.addEventListener('click', () => {
        toggle.parentNode.classList.toggle('active')
    })
})

const body = document.body
const slides = document.querySelectorAll('.slide')
const leftBtn = document.getElementById('left')
const rightBtn = document.getElementById('right')

let activeSlide = 0

rightBtn.addEventListener('click', () => {
    activeSlide++

    if (activeSlide > slides.length - 1) {
        activeSlide = 0
    }
    setActiveSlide()
    setBgToBody()

})

leftBtn.addEventListener('click', () => {
    activeSlide--

    if (activeSlide < 0) {
        activeSlide = slides.length - 1
    }
    setActiveSlide()
      setBgToBody()

})

  setBgToBody()

function setBgToBody() {
     document.getElementById("br2").style.backgroundImage =  slides[activeSlide].style.backgroundImage
    //document.querySelectorAll("faq.active").style.backgroundImage =  slides[activeSlide].style.backgroundImage
    if (activeSlide==0)
    {
        document.getElementById("h1a").innerText ="Số thứ tự: 1";
        document.getElementById("h2a").innerText ="Chó: Husky ";
        document.getElementById("h3a").innerText ="Giá: 10000$";
    }
    if (activeSlide==1)
    {
        document.getElementById("h1a").innerText ="Số thứ tự: 2";
        document.getElementById("h2a").innerText ="Chó: Corki ";
        document.getElementById("h3a").innerText ="Giá: 10000$";
    }
    if (activeSlide==2)
    {
        document.getElementById("h1a").innerText ="Số thứ tự: 3";
        document.getElementById("h2a").innerText ="Chó: Samoyed ";
        document.getElementById("h3a").innerText ="Giá: 100000$";
    }
    if (activeSlide==3)
    {
        document.getElementById("h1a").innerText ="Số thứ tự: 4 ";
        document.getElementById("h2a").innerText ="Chó: Shiba ";
        document.getElementById("h3a").innerText ="Giá: 10000$";
    }

    if (activeSlide==4)
    {
        document.getElementById("h1a").innerText ="Số thứ tự: 5";
        document.getElementById("h2a").innerText ="Chó: Kha ";
        document.getElementById("h3a").innerText ="Giá: 30000$";
    }


}

function setActiveSlide() {
    slides.forEach((slide) => slide.classList.remove('active'))

    slides[activeSlide].classList.add('active')
}
