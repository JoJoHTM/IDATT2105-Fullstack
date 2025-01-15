<script setup>
    import { onMounted } from 'vue';

    function duplicateButton() {
        var columnStart = 1;
        var columnEnd = 2;
        var rowStart = 2;
        var rowEnd = 3;
        var counter = 1;
        for (let j = 0; j < 3; j++) {
            for (let i = 0; i < 4; i++) {
                var newButton = document.createElement("button");
                newButton.setAttribute("id", `button`);
                newButton.textContent = `${counter}`;
                newButton.setAttribute("style", `grid-column: ${columnStart}/${columnEnd};`);
                newButton.setAttribute("style", `grid-row: ${rowStart}/${rowEnd};`);
                document.getElementById("frame").appendChild(newButton);
                columnStart++;
                columnEnd++;
                counter++;
            }
            rowStart++;
            rowEnd++;
            columnStart = 1;
            columnEnd = 2;
        }
    }

    onMounted(() => {
        duplicateButton();
    });
</script>