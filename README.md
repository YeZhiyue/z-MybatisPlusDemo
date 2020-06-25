<form class="form-inline" th:each="info:${userInfo}" action="/user/selectUser" method="post">
    <div class="form-group">
        <label>idGe</label>
        <input type="text" class="form-control" th:value="${info.idGe}" value="1" name="idGe"
               placeholder="id >= idGe">
    </div>
    <div class="form-group">
        <label>idLe</label>
        <input type="text" class="form-control" th:value="${info.idLe}" value="40" name="idLe"
               placeholder="id <= idLe">
    </div>
    <div class="form-group">
        <label>Name</label>
        <input type="text" class="form-control" th:value="${info.name}" value="" name="name"
               placeholder="name like %..%">
    </div>
    <div class="form-group">
        <label>ageGe</label>
        <input type="text" class="form-control" th:value="${info.ageGe}" value="10" name="ageGe"
               placeholder="age >= ageGe">
    </div>
    <div class="form-group">
        <label>ageLe</label>
        <input type="text" class="form-control" th:value="${info.ageLe}" value="39" name="ageLe"
               placeholder="age <= ageLe">
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="text" class="form-control" th:value="${info.email}" value="" name="email"
               placeholder="email like %..%">
    </div>
    <div class="checkbox">
        <label>
            <input type="radio" name="crud" value="select" checked> select </label> <label>
        <input type="radio" name="crud" value="delete"> delete </label>
    </div>
    <button type="submit" class="btn btn-default">提交</button>
</form>
