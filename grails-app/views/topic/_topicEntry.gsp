<h1><a href="#">${topic?.name}</a>
</h1>
<p class="lead">by <a href="#">${topic?.createdByUsername}</a>
</p>
<hr>
<p><span class="glyphicon glyphicon-time"></span> Posted on ${topic?.dateCreated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>
<p></p><span class="glyphicon glyphicon-time"></span> Last updated on ${topic?.lastUpdated?.format("EEE dd, yyyy 'at' hh:mm a")}</p>
<hr>
<img src="http://placehold.it/900x300" class="img-responsive">
<hr>
<p>${topic?.description}</p>
<a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
