/** Modal delete button */
$(document).ready(function () {
    var trigger = $('.hamburger'),
        overlay = $('.overlay'),
       isClosed = false;
  
      trigger.click(function () {
        hamburger_cross();      
      });
  
      function hamburger_cross() {
  
        if (isClosed == true) {          
          overlay.hide();
          trigger.removeClass('is-open');
          trigger.addClass('is-closed');
          isClosed = false;
        } else {   
          overlay.show();
          trigger.removeClass('is-closed');
          trigger.addClass('is-open');
          isClosed = true;
        }
    }
    
    $('[data-toggle="offcanvas"]').click(function () {
          $('#wrapper').toggleClass('toggled');
    });  
  });

/** Modal buttons */
$(document).ready(function () {
  /** Modal edit button */
  $('.table .edit').on('click', function(event) {
    event.preventDefault();
      
    var href = $(this).attr('href');

    $.get(href, function (student) {
      $('#idEdit').val(student.id);
      $('#firstNameEdit').val(student.firstName);
      $('#lastNameEdit').val(student.lastName);
      $('#emailEdit').val(student.email);
      $('#numberEdit').val(student.number);
      });

  $('#editStudentModal').modal();
  });

  /** Modal delete button */
  $('.table .delete').on('click', function(event) {
    event.preventDefault();
      
    var href = $(this).attr('href');

    $.get(href, function () {});

    $('#deleteStudentModal').modal();
  });
});