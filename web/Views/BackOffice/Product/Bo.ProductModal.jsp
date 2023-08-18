<%-- 
    Document   : Bo.ProductModal
    Created on : Mar 7, 2022, 7:31:03 PM
    Author     : Tham Jun Yuan
--%>
<!-- Submit Successful Modal -->
<div class="modal fade" id="submit-success" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Success</h5>
        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
      </div>
        <div class="modal-body">Congratulations ! You have added successfully !</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal" onclick="location.href = 'Bo.ProductSummary.jsp';">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="delete-product-image" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-capitalize" id="exampleModalLabel">confirmation</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">Are you sure to delete the image?</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-mdb-dismiss="modal" id="confirm-delete-product-image">Confirm</button>
            </div>
        </div>
    </div>
</div>

<!-------------------------------------- Activate Modal ---------------------------------->
<div class="modal fade" id="product-activate" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Activation</h5>
        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
      </div>
        <div class="modal-body">Are you sure you want to <b>Activate</b> this product?</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Close</button>
        <button type="button" id="product-activate-btn"   class="btn btn-primary">Confirm</button>
      </div>
    </div>
  </div>
</div>

<!--------------------------------------- Deactivate Modal ------------------------------>
<div class="modal fade" id="product-deactivate" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Deactivation</h5>
        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
      </div>
        <div class="modal-body">Are you sure you want to <b>Deactivate</b> this product?</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Close</button>
        <button type="button" id="product-deactivate-btn"  class="btn btn-primary">Confirm</button>
      </div>
    </div>
  </div>
</div>
