
/**
 * Fix for KULRICE-7795 as suggested by Brian. We need to remove this method once we get the same in next rice upgrade M3/M4
 */
writeMessagesForPage = function() {
    var page = jQuery("[data-type='Page']");
    var pageId = page.attr("id");
    var data = page.data(kradVariables.VALIDATION_MESSAGES);
    var messageMap = data.messageMap;
    if (!messageMap) {
        messageMap = {};
        data.messageMap = messageMap;
    }
    writeMessagesForGroup(pageId, data);
    writeMessagesForChildGroups(pageId);
    jQuery(".uif-errorMessageItem > div").show();
}

function removeSelfFromDropdowns(headerTextNameContainerId) {
    jQuery('select[name=clusterIdForAOMove]').each(function () {
        var dropdownId = jQuery(this).attr('id');
        var lineIndex = dropdownId.indexOf('_line');
        var controlIndex = dropdownId.indexOf('_control');
        var postFix = '';
        if (lineIndex > -1) {
            if (controlIndex > -1) {
                postfix = dropdownId.substring(lineIndex, controlIndex);
            } else {
                postfix = dropdownId.substring(lineIndex);
            }
        }
        var headerContainer = headerTextNameContainerId + postfix;
        var headerText = jQuery("#" + headerContainer).find("label").text();
        var braketIndex = headerText.indexOf('(');
        if (braketIndex > -1) {
            headerText = headerText.substring(0, braketIndex);
        }

        jQuery("#" + dropdownId + " > option").each(function (i) {
            var optionText = jQuery.trim(jQuery.trim(jQuery(this).text()));
            headerText = jQuery.trim(headerText);
            if (headerText == optionText) {
                jQuery(this).remove();
            }
        });
    });
    toggleAssignButton();
}

function addDropdownGroup(dropdownId, prepend, groupText, optionList, withinPortal) {
    if(withinPortal){
        return;
    }
    var dropdown = jQuery("#" + dropdownId);
    if (dropdown != 'undefined') {
        if (optionList != 'undefined') {
            if (prepend) {
                dropdown.prepend('<optgroup label="' + groupText + '"></optgroup>');
            }  else{
                dropdown.append('<optgroup label="' + groupText + '"></optgroup>');
            }
            jQuery.each(optionList, function (key, value) {
                addOption(dropdown, prepend, key, value);
            });
        }
    }
}

function addOption(dropdown, prepend, key, value){
    if (prepend) {
        dropdown.prepend(jQuery('<option>', {key : value}).text(value));
    }  else{
        dropdown.append(jQuery('<option>', {value: key}).text(value));
    }
}

function populateLightboxForm(propertyContainerId, defaultPropertyValues){
//    var lightboxForm = jQuery("#" + "kualiLightboxForm");
    jQuery.each(defaultPropertyValues, function (lightboxPropId, kualiPropId) {
        var lightboxInput = jQuery("#kualiLightboxForm :input[name='" + lightboxPropId + "']");
        var kualiProp = jQuery("#" + kualiPropId);
        lightboxInput.val(kualiProp.text());
    });
}

function toggleAssignButton(){
    var table = jQuery('#KS-ManageRegistrationGroupsPage-UnassignedActivityOfferingsPerFormatSection').find('table');
    var checkedCheckboxesCount = jQuery(table).find('input:checkbox:checked').length;
    if(checkedCheckboxesCount > 0){
        jQuery("#move_ao_button").removeAttr("disabled");
    }else{
        jQuery("#move_ao_button").attr("disabled", "disabled");
    }
}

/*
function updateCollectionAndRelatedItem(jqObject, collectionGroupId, updateAfterId){
    if(jqObject && collectionGroupId){
        collectionGroupId = jqObject.closest("[id^='" + collectionGroupId + "']").attr("id");
        collectionGroupId = collectionGroupId.replace("_group", "");
		var otherElementToBlock = jq("#" + updateAfterId + "_div");
        var updateComponentCallback = function(htmlContent){
	    	var component = jq("#" + updateAfterId + "_div", htmlContent);

			otherElementToBlock.unblock({onUnblock: function(){
					//replace component
					if(jq("#" + updateAfterId + "_div").length){
						jq("#" + updateAfterId + "_div").replaceWith(component);
					}
					runHiddenScripts(updateAfterId + "_div");
				}
			});
	    };
        var elementToBlock = jq("#" + collectionGroupId + "_div");
	    var updateCollectionCallback = function(htmlContent){
	    	var component = jq("#" + collectionGroupId + "_div", htmlContent);

			elementToBlock.unblock({onUnblock: function(){
					//replace component
					if(jq("#" + collectionGroupId + "_div").length){
						jq("#" + collectionGroupId + "_div").replaceWith(component);
					}
					runHiddenScripts(collectionGroupId + "_div");
                    ajaxSubmitForm("updateComponent", updateComponentCallback,
			            {reqComponentId: updateAfterId, skipViewInit: "true"}, otherElementToBlock);
				}
			});
	    };

	    var methodToCall = jq("input[name='methodToCall']").val();
		ajaxSubmitForm(methodToCall, updateCollectionCallback, {reqComponentId: collectionGroupId, skipViewInit: "true"},
				elementToBlock);
	}
}

    function removeFromCart(){
        var row = jq(this).closest("tr.keyRow");
        var name = jq(row).find(".timeKeyName").text();
        if(confirm("Remove "+ name +" from your cart?")){
            var id = jq(row).attr("name");
            writeHiddenToForm("methodToCall", "removeFromCart");
            writeHiddenToForm('jumpToId' , 'TOP');
            writeHiddenToForm('renderFullView' , 'true');
            writeHiddenToForm('actionParameters[itemId]' , id);
            jq('#kualiForm').submit();
        }
    }*/
